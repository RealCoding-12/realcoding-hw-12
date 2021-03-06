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

    @GetMapping("/dogs/addMedical/{name}/{ownerName}/{ownerPhoneNumber}/{medicalRecord}")
    public void addMedicalRecord(@PathVariable String name, String ownerName, String ownerPhoneNumber, String medicalRecord) {

        dogManagementService.addMedicalRecord(name, ownerName, ownerPhoneNumber, medicalRecord);
    }

    @GetMapping("/dogs/changeKind/{name}/{ownerName}/{ownerPhoneNumber}/{kind}")
    public void changeKind(@PathVariable String name, String ownerName, String ownerPhoneNumber, String kind) {

        dogManagementService.updateDogkind(name, ownerName, ownerPhoneNumber, kind);
    }

    @GetMapping("/dogs/changeDog/{name}/{ownerName}/{ownerPhoneNumber}/{newName}/{newOwnerName}/{newOwnerPhoneNumber}/{newKind}")
    public void replaceDog(@PathVariable String name, String ownerName, String ownerPhoneNumber, String newName, String newOwnerName, String newOwnerPhoneNumber, String newKind) {

        dogManagementService.updateDog(name, ownerName, ownerPhoneNumber, newName, newOwnerName, newOwnerPhoneNumber, newKind);
    }
}
