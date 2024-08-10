package com.patika.bloghubemailservice.repository;

import com.patika.bloghubemailservice.model.Email;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface EmailRepository extends MongoRepository<Email,Long> {





    /*private List<Email> emailList = new ArrayList<>();

    public void save(Email email) {
        emailList.add(email);
    }*/
}
