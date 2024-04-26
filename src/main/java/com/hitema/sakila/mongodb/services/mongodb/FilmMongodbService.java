package com.hitema.sakila.mongodb.services.mongodb;

import com.hitema.sakila.mongodb.models.mongodb.CityMongodb;
import com.hitema.sakila.mongodb.models.mongodb.CountryMongodb;
import com.hitema.sakila.mongodb.models.mongodb.FilmMongodb;

import java.util.List;

public interface FilmMongodbService {
    FilmMongodb create(FilmMongodb filmMongodb);
    List<FilmMongodb> readAll();
    FilmMongodb read(String id);
    FilmMongodb update(FilmMongodb filmMongodb);
    Boolean delete(String id);
}
