package ar.edu.utn.frc.tup.lciii.controllers;

import ar.edu.utn.frc.tup.lciii.dtos.UserDto;
import ar.edu.utn.frc.tup.lciii.models.User;
import ar.edu.utn.frc.tup.lciii.services.DummyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DummyController {

    @Autowired
    private DummyService dummyService;

    @GetMapping("")
    public ResponseEntity<UserDto> getDummyList(){
        List<User> dummyList = dummyService.getDummyList();
        return null;
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getDummyList(@PathVariable Long id){
        User dummy = dummyService.getDummy(id);
        return null;
    }

    @PostMapping("")
    public ResponseEntity<UserDto> createDummy(UserDto dummyDto){
        User dummy = dummyService.createDummy(null);
        return null;
    }

    @PutMapping("")
    public ResponseEntity<UserDto> updateDummy(UserDto dummyDto){
        User dummy = dummyService.updateDummy(null);
        return null;
    }

    @DeleteMapping("")
    public ResponseEntity<Void> deleteDummy(UserDto dummyDto){
        dummyService.deleteDummy(null);
        return null;
    }
}
