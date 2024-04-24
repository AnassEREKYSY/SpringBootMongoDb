package com.hitema.sakila.mongodb.services;

import com.hitema.sakila.mongodb.models.User;
import com.hitema.sakila.mongodb.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService{
    UserRepository userRepository;
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User create(User user) {
        return this.userRepository.save(user);
    }

    @Override
    public List<User> readAll() {
        return this.userRepository.findAll();
    }

    @Override
    public User read(String id) {

        return this.userRepository.findById(id).orElse(null);
    }

    @Override
    public User update(User user) {

        return this.userRepository.save(user);
    }

    @Override
    public List<User> search(String query) {
        List<User> allUsers = userRepository.findAll();
        return allUsers.stream()
                .filter(user -> user.getFirstName().contains(query) || user.getLastName().contains(query))
                .collect(Collectors.toList());
    }

    @Override
    public boolean delete(String id) {
        this.userRepository.deleteById(id);
        return (this.read(id)==null);
    }
}
