package com.hitema.sakila.mongodb.models.mongodb;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDateTime;
import java.time.Year;

@Document(collection = "film")
public class FilmMongodb {
    @Id
    private String id;

    @Field("title")
    private String title;

    @Field("description")
    private String description;

    private LangueMongodb langueMongodb;

    public FilmMongodb(String id, String title, String description, LangueMongodb langueMongodb) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.langueMongodb = langueMongodb;
    }

    public FilmMongodb(String string, String title, LocalDateTime lastUpdate, Year releaseYear, LangueMongodb langue) {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LangueMongodb getLangueMongodb() {
        return langueMongodb;
    }

    public void setLangueMongodb(LangueMongodb langueMongodb) {
        this.langueMongodb = langueMongodb;
    }


}
