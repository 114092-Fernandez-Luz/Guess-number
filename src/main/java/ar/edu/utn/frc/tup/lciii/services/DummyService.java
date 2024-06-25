package ar.edu.utn.frc.tup.lciii.services;

import ar.edu.utn.frc.tup.lciii.models.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DummyService {
    User getDummy(Long id);
    List<User> getDummyList();
    User createDummy (User dummy);
    User updateDummy(User dummy);
    Void deleteDummy(User dummy);
}
