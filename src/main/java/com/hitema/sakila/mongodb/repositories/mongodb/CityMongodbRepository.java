package com.hitema.sakila.mongodb.repositories.mongodb;

import com.hitema.sakila.mongodb.models.mongodb.CityMongodb;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CityMongodbRepository extends MongoRepository<CityMongodb, String> {
}
