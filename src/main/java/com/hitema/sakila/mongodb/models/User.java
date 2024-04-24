package com.hitema.sakila.mongodb.models;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.stereotype.Indexed;

import java.time.LocalDateTime;

@Document(collection = "user")
public class User {

    @Id
    private String id;
    @Field("email")
    private String email;
    @Field("first_name")
    private String firstName;
    @Field("last_name")
    private String lastName;
    @Field("last_update")
    private LocalDateTime lastUpdate;

    public User(String firstName, String lastName, String email, LocalDateTime lastUpdate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.lastUpdate = lastUpdate;
    }

    // Getters and setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDateTime getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(LocalDateTime lastUpdate) {
        this.lastUpdate = lastUpdate;
    }
}
