package com.hitema.sakila.mongodb.services;

import com.hitema.sakila.mongodb.models.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

@SpringBootTest
class UserServiceImplTest {


    @Autowired
    UserService userService;

    @Test
    void createDelete() {
        User user = new User("John", "Doe", "john.doe@example.com", LocalDateTime.now());

        User savedUser = userService.create(user);
        Assertions.assertEquals(user, savedUser);
        Assertions.assertNotNull(savedUser);


    }

    @Test
    void readAll() {

    }

    @Test
    void read() {

    }

    @Test
    void update() {

    }

}