package org.cnu.realcoding.cnurealcodinghwdogmanagement12.controller;

import org.cnu.realcoding.cnurealcodinghwdogmanagement12.domain.Dog;
import org.cnu.realcoding.cnurealcodinghwdogmanagement12.service.DogManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DogController {

    @Autowired
    private DogManagementService dogManagementService;

    @PostMapping("/dogs")
    @ResponseStatus(HttpStatus.CREATED)
    public void createDogs(@RequestBody Dog dog) {
        dogManagementService.insertDog(dog);
    }

    @GetMapping("/dogs")
    public List<Dog> getAllDogs() {

        return dogManagementService.getAllDogs();
    }

    @GetMapping("/dogs/name/{name}")
    public Dog getDogByName(@PathVariable String name) {

        return dogManagementService.getDogByName(name);
    }

    @GetMapping("/dogs/ownerName/{ownerName}")
    public Dog getDogByOwnerName(@PathVariable String ownerName) {

        return dogManagementService.getdogByOwnerName(ownerName);
    }
    
    @GetMapping("/dogs/phone/{ownerPhoneNumber}")
    public Dog getDogByOwnerPhoneNumber(@PathVariable String ownerPhoneNumber) {


        return dogManagementService.getdogbyOwnerPhoneNumber(ownerPhoneNumber);
    }

    @GetMapping("/dogs/triple/{name}/{ownerName}/{ownerPhoneNumber}")
    public Dog getDogByAllInfoExceptRecords(@PathVariable String name, String ownerName, String ownerPhoneNumber) {

        return dogManagementService.getConditionByTriple(name, ownerName, ownerPhoneNumber);
    }

    @GetMapping("/dogs/{dog, newDog}")
    @ResponseStatus(HttpStatus.OK)
    public void replaceDogs(@PathVariable Dog dog, Dog newDog) {

//        dogManagementService.replaceDogs(dog, newDog);
//        dogManagement와 merge 할 때 함수명 확인 및 수정
    }
}
