package com.hitema.sakila.mongodb.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "city")
public class City {
    @Id
    private String id;
    @Field("city")
    private String name;
    @DBRef
    private Country country;
}
