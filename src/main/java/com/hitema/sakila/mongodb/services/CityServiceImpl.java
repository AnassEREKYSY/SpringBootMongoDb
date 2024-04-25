package com.hitema.sakila.mongodb.services;

import com.hitema.sakila.mongodb.models.City;
import com.hitema.sakila.mongodb.repositories.CityRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityServiceImpl implements CityService {

    CityRepository cityRepository;
    public CityServiceImpl(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }
    @Override
    public City create(City city) {
        return this.cityRepository.save(city);
    }

    @Override
    public List<City> readAll() {
        return this.cityRepository.findAll();
    }

    @Override
    public City read(String id) {
        return this.cityRepository.findById(id).orElse(null);
    }

    @Override
    public City update(City city) {
        return this.cityRepository.save(city);
    }

    @Override
    public Boolean delete(String id) {
        this.cityRepository.deleteById(id);
        return (read(id) == null);
    }

}
