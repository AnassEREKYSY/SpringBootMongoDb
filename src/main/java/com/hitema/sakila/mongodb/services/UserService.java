package com.hitema.sakila.mongodb.services;

import com.hitema.sakila.mongodb.models.User;
import java.util.List;

public interface UserService {
    public User create(User user);
    public List<User> readAll();
    public User read(String id);
    public User update(User user);
    List<User> search(String query);
    public boolean delete(String id);

}
