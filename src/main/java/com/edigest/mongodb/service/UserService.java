package com.edigest.mongodb.service;

import com.edigest.mongodb.entity.User;
import com.edigest.mongodb.repository.UserRespository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Component
public class UserService {
    @Autowired
    private UserRespository userRespository;
    private static final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public void saveUser(User entry) {
        userRespository.save(entry);
    }

    public boolean saveNewUser(User entry) {
        try {
            entry.setPassword(passwordEncoder.encode(entry.getPassword()));
            entry.setRoles(Arrays.asList("USER"));
            userRespository.save(entry);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public void saveAdmin(User entry) {
        entry.setPassword(passwordEncoder.encode(entry.getPassword()));
        entry.setRoles(Arrays.asList("USER", "ADMIN"));
        userRespository.save(entry);
    }

    public List<User> getAll() {
        return userRespository.findAll();
    }

    public Optional<User> findById(ObjectId id) {
        return userRespository.findById(id);
    }

    public void deleteById(ObjectId id) {
        userRespository.deleteById(id);
    }

    public User findByUserName(String userName) {
        return userRespository.findByUserName(userName);
    }

    public void deleteByUserName(String userName) {
        userRespository.deleteByUserName(userName);
    }
}
