package org.cnu.realcoding.cnurealcodinghwdogmanagement12.service;

import org.cnu.realcoding.cnurealcodinghwdogmanagement12.domain.Dog;
import org.cnu.realcoding.cnurealcodinghwdogmanagement12.repository.DogRepository;
import org.springframework.beans.factory.annotation.Autowired;


import java.util.List;

public class DogManagementService {
    @Autowired
    private DogRepository dogRepository;

    public void insertDog(Dog dog) {
        dogRepository.insertDog(dog);
    }

    public Dog getDogByName(String name) {
        Dog dog = dogRepository.findDog(name);

        /*if(dog == null) {
            throw new DogNotFoundException();
        }*/

        return dog;
    }

    public List<Dog> getAllDogs() {

        return dogRepository.findAllDogs();
    }
}
