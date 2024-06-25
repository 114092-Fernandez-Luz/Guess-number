package ar.edu.utn.frc.tup.lciii.services.impl;

import ar.edu.utn.frc.tup.lciii.entities.MatchEntity;
import ar.edu.utn.frc.tup.lciii.entities.UserEntity;
import ar.edu.utn.frc.tup.lciii.models.*;
import ar.edu.utn.frc.tup.lciii.repositories.MatchRepository;
import ar.edu.utn.frc.tup.lciii.services.MatchService;
import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.Random;

@Service
public class MatchServiceImpl implements MatchService {

    @Autowired
    private MatchRepository matchRepository;

    @Autowired
    private ModelMapper modelMapper;

    private final Random random = new Random();

    @Override
    public Match createMatch(User user, MatchDifficult difficulty) {
        MatchEntity matchEntity = new MatchEntity();
        matchEntity.setUserEntity(modelMapper.map(user, UserEntity.class));
        matchEntity.setDifficult(difficulty);
        switch (difficulty){
            case HARD -> matchEntity.setRemaningTries(5);
            case MEDIUM -> matchEntity.setRemaningTries(8);
            case EASY -> matchEntity.setRemaningTries(10);
        }
        matchEntity.setNumberToGuess(random.nextInt(101));
        matchEntity.setStatus(MatchStatus.PLAYING);
        matchEntity.setCreatedAt(LocalDateTime.now());
        matchEntity.setUpdatedAt(LocalDateTime.now());
        MatchEntity matchEntitySaved = matchRepository.save(matchEntity);
        return modelMapper.map(matchEntitySaved, Match.class);
    }

    @Override
    public Match getMatchById(Long matchId) {
        Optional<MatchEntity> matchEntityOptional = matchRepository.findById(matchId);
        if(matchEntityOptional.isEmpty()){
            throw  new EntityNotFoundException();
        } else{
            return modelMapper.map(matchEntityOptional.get(), Match.class);
        }

    }

    @Override
    public RoundMatch playMatch(Match match, Integer number) {
        RoundMatch roundMatch = new RoundMatch();
        roundMatch.setMatch(match);
        //verifico el estado del match
        if(match.getStatus().equals(MatchStatus.FINISH)){
            return null;
        }
        if(match.getNumberToGuess().equals(number)){
            match.setStatus(MatchStatus.FINISH);
            roundMatch.setRespuesta("GANO");

            //TODO: Calcular scores
        }else{
            match.setRemaningTries(match.getRemaningTries()-1);
            if(match.getRemaningTries().equals(0)){
                match.setStatus(MatchStatus.FINISH);
                roundMatch.setRespuesta("PERDIO");
            }else{
                if(number > match.getNumberToGuess()){
                    roundMatch.setRespuesta("MENOR");
                }else{
                    roundMatch.setRespuesta("MAYOR");

                }
            }
        }
        UserEntity userEntity = modelMapper.map(match.getUser(), UserEntity.class);
        MatchEntity matchEntity = modelMapper.map(match,MatchEntity.class);
        matchEntity.setUserEntity(userEntity);
        matchEntity.setUpdatedAt(LocalDateTime.now());
        matchRepository.save(matchEntity);
       return  roundMatch;
    }
}
