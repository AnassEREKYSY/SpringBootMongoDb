package com.hitema.sakila.mongodb.services.mongodb;

import com.hitema.sakila.mongodb.models.mongodb.CityMongodb;
import com.hitema.sakila.mongodb.models.mongodb.CountryMongodb;

import java.util.List;

public interface CityMongodbService {
    CityMongodb create(CityMongodb city);
    List<CityMongodb> readAll();
    List<CountryMongodb> getAll();
    CityMongodb read(String id);
    CityMongodb update(CityMongodb city);
    Boolean delete(String id);
}
