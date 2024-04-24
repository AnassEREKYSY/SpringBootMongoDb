package com.hitema.sakila.mongodb.controllers;

import com.hitema.sakila.mongodb.models.User;
import com.hitema.sakila.mongodb.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/create")
    public User create(@RequestBody User user) {
        return userService.create(user);
    }

    @GetMapping("/read/{id}")
    public User read(@PathVariable String id) {
        return userService.read(id);
    }

    @GetMapping({"/all","/"})
    public List<User> readAll() {
        return userService.readAll();
    }

    @PutMapping("/update/{id}")
    public User update(@RequestBody User user) {
        return userService.update(user);
    }

    @GetMapping("/search")
    public List<User> searchUsers(@RequestParam("query") String query) {
        return userService.search(query);
    }

    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable String id) {
        userService.delete(id);
        return (read(id)==null);
    }
}