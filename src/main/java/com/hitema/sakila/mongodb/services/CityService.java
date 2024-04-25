package com.hitema.sakila.mongodb.services;

import com.hitema.sakila.mongodb.models.City;

import java.util.List;

public interface CityService {
    City create(City city);
    List<City> readAll();
    City read(String id);
    City update(City city);
    Boolean delete(String id);
}
