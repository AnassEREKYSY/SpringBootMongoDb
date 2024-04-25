package com.hitema.sakila.mongodb.services.mongodb;

import com.hitema.sakila.mongodb.models.mongodb.CityMongodb;
import com.hitema.sakila.mongodb.repositories.mongodb.CityMongodbRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityMongodbServiceImpl implements CityMongodbService {

    CityMongodbRepository cityMongodbRepository;
    public CityMongodbServiceImpl(CityMongodbRepository cityMongodbRepository) {
        this.cityMongodbRepository = cityMongodbRepository;
    }
    @Override
    public CityMongodb create(CityMongodb city) {
        return this.cityMongodbRepository.save(city);
    }

    @Override
    public List<CityMongodb> readAll() {
        return this.cityMongodbRepository.findAll();
    }

    @Override
    public CityMongodb read(String id) {
        return this.cityMongodbRepository.findById(id).orElse(null);
    }

    @Override
    public CityMongodb update(CityMongodb city) {
        return this.cityMongodbRepository.save(city);
    }

    @Override
    public Boolean delete(String id) {
        this.cityMongodbRepository.deleteById(id);
        return (read(id) == null);
    }

}
