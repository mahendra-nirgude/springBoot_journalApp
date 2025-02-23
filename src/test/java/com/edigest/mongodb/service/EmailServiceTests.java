package com.edigest.mongodb.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class EmailServiceTests {

    @Autowired
    private EmailService emailService;


    @Test
    public void sendMail() {
        boolean b = emailService.sendEmail("mnirgude32@gmail.com", "This is test email", "Hello, Testing email");
        System.out.println(b);
    }
}
