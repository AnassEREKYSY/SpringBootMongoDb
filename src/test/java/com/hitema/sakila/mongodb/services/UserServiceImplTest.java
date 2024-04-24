package com.hitema.sakila.mongodb.services;

import com.hitema.sakila.mongodb.models.User;
import com.hitema.sakila.mongodb.repositories.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.logging.LoggerFactory;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserServiceImplTest {

    private static final Logger log = (Logger) LoggerFactory.getLogger(UserServiceImplTest.class);

    @Autowired
    UserService userService;

    @Test
    void createDelete() {
        User user = new User("John", "Doe", "john.doe@example.com", null);

        User savedUser = userService.create(user);
        Assertions.assertEquals(user, savedUser);
        Assertions.assertNotNull(savedUser);

        boolean deletedUser= userService.delete(savedUser.getId());
        Assertions.assertTrue(deletedUser);
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