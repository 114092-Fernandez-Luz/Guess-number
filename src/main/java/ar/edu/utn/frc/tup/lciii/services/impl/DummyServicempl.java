package ar.edu.utn.frc.tup.lciii.services.impl;

import ar.edu.utn.frc.tup.lciii.models.User;
import ar.edu.utn.frc.tup.lciii.repositories.DummyRepository;
import ar.edu.utn.frc.tup.lciii.repositories.UserRepository;
import ar.edu.utn.frc.tup.lciii.services.DummyService;
import ar.edu.utn.frc.tup.lciii.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DummyServicempl implements DummyService {

    @Autowired
    private DummyRepository dummyRepository;
    @Override
    public User getDummy(Long id) {
        return null;
    }

    @Override
    public List<User> getDummyList() {
        return List.of();
    }

    @Override
    public User createDummy(User dummy) {
        return null;
    }

    @Override
    public User updateDummy(User dummy) {
        return null;
    }

    @Override
    public Void deleteDummy(User dummy) {
        return null;
    }
}
