package com.edigest.mongodb.controller;

import com.edigest.mongodb.entity.User;
import com.edigest.mongodb.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/public")
public class PublicController {
    @Autowired
    private UserService userService;

    @GetMapping("/health-check")
    public String healthCheck() {
        log.info("Inside healthCheck method....");
        return "ok";
    }

    @PostMapping("/create-user")
    public boolean createUser(@RequestBody User user) {
        userService.saveNewUser(user);
        return true;
    }
}
