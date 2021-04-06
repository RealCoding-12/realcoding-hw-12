package org.cnu.realcoding.cnurealcodinghwdogmanagement12.service;

import org.cnu.realcoding.cnurealcodinghwdogmanagement12.domain.Dog;
import org.cnu.realcoding.cnurealcodinghwdogmanagement12.exception.AlreadyDataException;
import org.cnu.realcoding.cnurealcodinghwdogmanagement12.exception.DogNotFoundException;
import org.cnu.realcoding.cnurealcodinghwdogmanagement12.repository.DogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class DogManagementService {
    @Autowired
    private DogRepository dogRepository;

    public void insertDog(Dog dog) {
        Dog condition = dogRepository.findDog(dog.getName(),dog.getOwnerName(),dog.getOwnerPhoneNumber());
        if (condition != null) {
            throw new AlreadyDataException();
        }
        else {
            dogRepository.insertDog(dog);
        }
    }

    public Dog getDogByName(String name) {
        Dog dog = dogRepository.findDog(name);

        if(dog == null) {
            throw new DogNotFoundException();
        }

        return dog;
    }
    public Dog getdogByOwnerName(String ownerName) {
        Dog dog = dogRepository.findDog_ownerName(ownerName);

        if(dog == null) {
            throw new DogNotFoundException();
        }
        return dog;
    }
    public Dog getdogbyOwnerPhoneNumber(String ownerPhoneNumber) {
        Dog dog = dogRepository.findDog_ownerPhoneNumber(ownerPhoneNumber);

        if(dog == null) {
            throw new DogNotFoundException();
        }
        return dog;
    }

    public Dog getConditionByTriple(String name,String ownerName,String ownerPhoneNumber) {
        Dog dog = dogRepository.findDog(name , ownerName , ownerPhoneNumber);

        if (dog == null) {
            throw new DogNotFoundException();
        }
        return dog;
    }
    public void updateDog() {
        dogRepository.editInfo();
    }
    public void updateDogkind(String newkind) {
        dogRepository.editKind(newkind);
    }

    public List<Dog> getAllDogs() {

        return dogRepository.findAllDogs();
    }

    public void addMedicalRecord(String name, String ownerName, String ownerPhoneNumber, String medicalRecord) {
        Dog dog = dogRepository.findDog(name, ownerName, ownerPhoneNumber);

        if(dog == null) {
            throw new DogNotFoundException();
        } else {
            dogRepository.addMedicalRecords(name, ownerName, ownerPhoneNumber, medicalRecord);
        }
    }
}
