package com.hitema.sakila.mongodb.services;

import com.hitema.sakila.mongodb.models.User;
import java.util.List;

public interface UserService {
    public User create(User user);
    public List<User> readAll();
    public User read(String id);
    public User update(User user);
    public boolean delete(String id);
    public List<User> readByFisrtNameOrLastName(String expr);
    public byte[] getPicture(String id);
    void savePicture(String id, byte[] picture);

}
