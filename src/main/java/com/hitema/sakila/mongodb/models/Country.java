package com.hitema.sakila.mongodb.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "country")
public class Country {
    @Id
    private String id;
    @Field("country")
    private String name;
}
