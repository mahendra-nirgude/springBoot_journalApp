package com.edigest.mongodb.repository;

import com.edigest.mongodb.entity.User;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;

@Component
public interface UserRespository extends MongoRepository<User, ObjectId> {

    User findByUserName(String username);

    void deleteByUserName(String userName);
}
