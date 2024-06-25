package ar.edu.utn.frc.tup.lciii.services.impl;

import ar.edu.utn.frc.tup.lciii.entities.MatchEntity;
import ar.edu.utn.frc.tup.lciii.entities.UserEntity;
import ar.edu.utn.frc.tup.lciii.models.Match;
import ar.edu.utn.frc.tup.lciii.models.MatchDifficult;
import ar.edu.utn.frc.tup.lciii.models.RoundMatch;
import ar.edu.utn.frc.tup.lciii.models.User;
import ar.edu.utn.frc.tup.lciii.repositories.MatchRepository;
import ar.edu.utn.frc.tup.lciii.repositories.UserRepository;
import ar.edu.utn.frc.tup.lciii.services.MatchService;
import ar.edu.utn.frc.tup.lciii.services.UserService;
import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private MatchService matchService;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public User createUser(String userName, String email) {
        Optional<UserEntity> userEntityOptional = userRepository.getByEmail(email);
        if (userEntityOptional.isPresent()) {
            return null;
        } else {
            UserEntity userEntity = new UserEntity();
            userEntity.setUserName(userName);
            userEntity.setEmail(email);
            UserEntity userEntitySaved = userRepository.save(userEntity);
            return modelMapper.map(userEntitySaved, User.class);
        }

    }

    @Override
    public Match createUserMatch(Long userId, MatchDifficult difficulty) {
        Optional<UserEntity> userEntityOptional = userRepository.findById(userId);
        if (userEntityOptional.isEmpty()) {
            throw new EntityNotFoundException();
        } else {
            User user = modelMapper.map(userEntityOptional.get(), User.class);
            return matchService.createMatch(user, difficulty);
        }

    }

    @Override
    public RoundMatch playUserMatch(Long userId, Long matchId, Integer numberToPlay) {
        Match match = matchService.getMatchById(matchId);
        //caso que se correspondan voy a jugar el juego de lo contrario no juego y sale error
        if (!match.getUser().getId().equals(userId)) {
            return null;

        } else {
            return matchService.playMatch(match, numberToPlay);
        }

    }

    @Override
    public User getUserById(Long id) {
        Optional<UserEntity> userEntity = userRepository.findById(id);
        if (userEntity != null) {
            return modelMapper.map(userEntity, User.class);
        } else {
            throw new EntityNotFoundException(String.format("The user id %s not found", id));
        }


    }

    @Override
    public User updateUser(Long id, User user) {
        Optional<UserEntity> userEntity = userRepository.findById(id);
        if (userEntity.isPresent()) {
            UserEntity userEntity1 = userEntity.get();
            userEntity1.setUserName(user.getUserName());
            userEntity1.setEmail(user.getEmail());

            userRepository.save(userEntity1);
            return modelMapper.map(userEntity1, User.class);
        } else {
            throw new EntityNotFoundException(String.format("The user id %s not found", id));

        }
    }

    @Override
    public Boolean deleteUser(Long id) {
        return null;
    }




}



