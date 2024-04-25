package com.hitema.sakila.mongodb.services.mysql;

import com.hitema.sakila.mongodb.models.mysql.CityMysql;
import com.hitema.sakila.mongodb.repositories.mysql.CityMysqlRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityMysqlServiceImpl implements CityMysqlService {

    CityMysqlRepository cityMysqlRepository;
    public CityMysqlServiceImpl(CityMysqlRepository cityMysqlRepository){
        this.cityMysqlRepository = cityMysqlRepository;
    }
    @Override
    public CityMysql create(CityMysql city) {
        return this.cityMysqlRepository.save(city);
    }

    @Override
    public List<CityMysql> readAll() {
        return this.cityMysqlRepository.findAll();
    }

    @Override
    public CityMysql read(Long id) {
        return this.cityMysqlRepository.findById(id).orElse(null);
    }

    @Override
    public CityMysql update(CityMysql city) {
        return this.cityMysqlRepository.save(city);
    }

    @Override
    public Boolean delete(Long id) {
        this.cityMysqlRepository.deleteById(id);
        return (this.read(id) == null);
    }
}
