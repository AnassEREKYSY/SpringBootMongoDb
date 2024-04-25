package com.hitema.sakila.mongodb.services.mongodb;

import com.hitema.sakila.mongodb.models.mongodb.CityMongodb;

import java.util.List;

public interface CityMongodbService {
    CityMongodb create(CityMongodb city);
    List<CityMongodb> readAll();
    CityMongodb read(String id);
    CityMongodb update(CityMongodb city);
    Boolean delete(String id);
}
