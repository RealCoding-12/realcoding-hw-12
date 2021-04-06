package org.cnu.realcoding.cnurealcodinghwdogmanagement12.repository;

import org.cnu.realcoding.cnurealcodinghwdogmanagement12.domain.Dog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.*;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import java.util.Iterator;
import java.util.List;

@Repository
public class DogRepository {
    @Autowired
    private MongoTemplate mongoTemplate;

    public Dog findDog(String name) {
        return mongoTemplate.findOne(Query.query(Criteria.where("name").is(name)), Dog.class);
    }

    public Dog findDog_ownerName(String ownerName) {
        return mongoTemplate.findOne(Query.query(Criteria.where("ownerName").is(ownerName)), Dog.class);
    }

    public Dog findDog_ownerPhoneNumber(String ownerPhoneNumber) {
        return mongoTemplate.findOne(Query.query(Criteria.where("ownerPhoneNumber").is(ownerPhoneNumber)), Dog.class);
    }

    public Dog findDog(String name, String ownerName, String ownerPhoneNumber) {
        List<Dog> sameDogName = mongoTemplate.find(Query.query(Criteria.where("name").is(name)), Dog.class);
        Iterator<Dog> iter = sameDogName.iterator();

        while(iter.hasNext()) {
            Dog temp = iter.next();
            if (temp.getOwnerName().equals(ownerName) && temp.getOwnerPhoneNumber().equals(ownerPhoneNumber)) {
                return temp;
            }
        }

        return null;
    }

    public void addMedicalRecords(String name, String ownerName, String ownerPhoneNumber, String medicalRecord) {
        Query query = new Query();
        Criteria criteria = new Criteria();

        String ask_list[] = {name, ownerName, ownerPhoneNumber};
        Criteria criteria_arr[] = new Criteria[ask_list.length];

        criteria_arr[0] = Criteria.where("name").is(name);
        criteria_arr[1] = Criteria.where("ownerName").is(ownerName);
        criteria_arr[2] = Criteria.where("ownerPhoneNumber").is(ownerPhoneNumber);

        query.addCriteria(criteria.andOperator(criteria_arr));

        mongoTemplate.findAndModify(query, new Update().addToSet("medicalRecords", medicalRecord), Dog.class);
    }

    public void insertDog(Dog dog) {
        mongoTemplate.insert(dog);
    }

    public List<Dog> findAllDogs() {
        return mongoTemplate.findAll(Dog.class);
    }

    public void editInfo() {
        Update update = new Update();
        mongoTemplate.updateMulti(new Query(), update, "Dog");
    }

    public void editKind(String newKind) {
        Query query = new Query();
        //업데이트 할 항목 정의
        Update update = new Update();
        update.set("kind", newKind);

        mongoTemplate.updateFirst(query, update, "Dog");
    }

}
