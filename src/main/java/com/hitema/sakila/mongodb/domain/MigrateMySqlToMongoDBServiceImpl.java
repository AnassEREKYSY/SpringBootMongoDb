package com.hitema.sakila.mongodb.domain;

import com.hitema.sakila.mongodb.models.mongodb.CityMongodb;
import com.hitema.sakila.mongodb.models.mongodb.CountryMongodb;
import com.hitema.sakila.mongodb.models.mongodb.FilmMongodb;
import com.hitema.sakila.mongodb.models.mongodb.LangueMongodb;
import com.hitema.sakila.mongodb.models.mysql.CityMysql;
import com.hitema.sakila.mongodb.models.mysql.FilmMysql;
import com.hitema.sakila.mongodb.services.mongodb.CityMongodbService;
import com.hitema.sakila.mongodb.services.mongodb.FilmMongodbService;
import com.hitema.sakila.mongodb.services.mysql.CityMysqlService;
import com.hitema.sakila.mongodb.services.mysql.FilmMysqlService;
import org.springframework.stereotype.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class MigrateMySqlToMongoDBServiceImpl implements MigrateMySqlToMongoDBService{
    private static final Logger log = LoggerFactory.getLogger(MigrateMySqlToMongoDBServiceImpl.class);

    private final CityMysqlService cityMysqlService;
    private final CityMongodbService cityMongodbService;

    private final FilmMongodbService filmMongodbService;
    private final FilmMysqlService filmMysqlService;

    public MigrateMySqlToMongoDBServiceImpl(
            CityMysqlService cityMysqlService,
            CityMongodbService cityMongodbService,
            FilmMongodbService filmMongodbService,
            FilmMysqlService filmMysqlService
    ){
        this.cityMysqlService = cityMysqlService;
        this.cityMongodbService = cityMongodbService;
        this.filmMongodbService = filmMongodbService;
        this.filmMysqlService = filmMysqlService;
    }

    @Override
    public Integer migrateCities() {
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

    @Override
    public Integer migrateFilms() {
        int nbr = 0;
        var films = filmMysqlService.readAll();
        LangueMongodb langue;
        FilmMongodb filmMongodb;
        for (FilmMysql film : films){
            if ( filmMysqlService.read(film.getId()) == null ) {
                langue = new LangueMongodb(Math.toIntExact(film.getLangueMysql().getId()), film.getLangueMysql().getName());
                filmMongodb = new FilmMongodb(film.getId().toString(), film.getTitle(), film.getLastUpdate(),film.getReleaseYear(), langue);
                filmMongodbService.create(filmMongodb);
                nbr++;
            }
        }
        return nbr;
    }
}
