package com.hitema.sakila.mongodb.domain;

import com.hitema.sakila.mongodb.models.mongodb.CityMongodb;
import com.hitema.sakila.mongodb.models.mongodb.CountryMongodb;
import com.hitema.sakila.mongodb.models.mysql.CityMysql;
import com.hitema.sakila.mongodb.services.mongodb.CityMongodbService;
import com.hitema.sakila.mongodb.services.mysql.CityMysqlService;
import org.springframework.stereotype.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class MigrateMySqlToMongoDBServiceImpl implements MigrateMySqlToMongoDBService{
    private static final Logger log = LoggerFactory.getLogger(MigrateMySqlToMongoDBServiceImpl.class);

    private final CityMysqlService cityMysqlService;
    private final CityMongodbService cityMongodbService;

    public MigrateMySqlToMongoDBServiceImpl(CityMysqlService cityMysqlService, CityMongodbService cityMongodbService){
        this.cityMysqlService = cityMysqlService;
        this.cityMongodbService = cityMongodbService;
    }

    @Override
    public Integer migrate() {
        int nbr = 0;
        var cities = cityMysqlService.readAll();
        CountryMongodb country;
        CityMongodb cityMdb;
        for (CityMysql city : cities){
            if ( cityMysqlService.read(city.getId()) == null ) {
                country = new CountryMongodb(Math.toIntExact(city.getCountry().getId()), city.getCountry().getName());
                cityMdb = new CityMongodb(city.getId().toString(), city.getName(), city.getCapital(), country);
                cityMongodbService.create(cityMdb);
                nbr++;
            }
        }
        return nbr;
    }
}
