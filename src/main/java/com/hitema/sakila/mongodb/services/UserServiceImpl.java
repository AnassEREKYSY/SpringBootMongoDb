package com.hitema.sakila.mongodb.services;

import com.hitema.sakila.mongodb.models.User;
import com.hitema.sakila.mongodb.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public boolean delete(String id) {
        this.userRepository.deleteById(id);
        return (this.read(id)==null);
    }

    @Override
    public List<User>  readByFisrtNameOrLastName(String expr) {
        return this.userRepository.findByFirstNameContainingOrLastNameContaining(expr,expr);
    }

    @Override
    public byte[] getPicture(String id) {
        return (read(id)!=null ? read(id).getPicture() : null);
    }

    @Override
    public void savePicture(String id, byte[] picture) {
        User user = read(id);
        if ( user !=null ){
            user.setPicture(picture);
            userRepository.save(user);
        }
    }
}
