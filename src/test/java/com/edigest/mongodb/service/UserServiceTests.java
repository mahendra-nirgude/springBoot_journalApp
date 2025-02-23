package com.edigest.mongodb.service;

import com.edigest.mongodb.entity.User;
import com.edigest.mongodb.repository.UserRespository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class UserServiceTests {
    @Autowired
    private UserRespository userRespository;
    @Autowired
    private UserService userService;

/*
    @BeforeEach
    void setUpBeforeAll() {
        //Before running all methods this method will execute
        System.out.println("Runnig before each");
    }
    @BeforeEach
    void setUpBeforeEach(){
        //Before running each method this method will execute
    }
        //Similar methods are @AfterEach, @AfterAll
*/

    @Disabled
    @Test
    public void testAdd() {
        assertEquals(5, 1 + 4);
    }

    @Disabled
    @ParameterizedTest
    @CsvSource({"ram", "shyam", "vipul"})
    public void findByUserName(String name) {
        assertNotNull(userRespository.findByUserName(name));
    }

    @Disabled
    @ParameterizedTest
    @ArgumentsSource(UserArgumentsProvider.class)
    public void saveNewUser(User user) {
        assertTrue(userService.saveNewUser(user));
    }

    @Disabled
    @ParameterizedTest
    @ValueSource(strings = {"1,1,2", "2,3,5", "4,5,10"})
    public void test(int a, int b, int expected) {
        assertEquals(expected, a + b);
    }
}
