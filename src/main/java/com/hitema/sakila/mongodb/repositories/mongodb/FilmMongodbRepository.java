package com.hitema.sakila.mongodb.repositories.mongodb;

import com.hitema.sakila.mongodb.models.mongodb.FilmMongodb;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface FilmMongodbRepository  extends MongoRepository<FilmMongodb,String> {
}
