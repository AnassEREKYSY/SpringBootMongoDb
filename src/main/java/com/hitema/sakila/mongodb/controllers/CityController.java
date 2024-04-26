package com.hitema.sakila.mongodb.controllers;


import com.hitema.sakila.mongodb.domain.MigrateMySqlToMongoDBService;
import com.hitema.sakila.mongodb.models.mongodb.CityMongodb;
import com.hitema.sakila.mongodb.models.mysql.CityMysql;
import com.hitema.sakila.mongodb.services.mongodb.CityMongodbService;
import com.hitema.sakila.mongodb.services.mysql.CityMysqlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cities")
public class CityController {

    CityMongodbService cityMongodbService;
    CityMysqlService cityMysqlService;
    private final MigrateMySqlToMongoDBService migrateMySqlToMongoDBService;

    @Autowired
    public CityController(CityMongodbService cityMongodbService, CityMysqlService cityMysqlService, MigrateMySqlToMongoDBService migrateMySqlToMongoDBService) {
        this.cityMongodbService = cityMongodbService;
        this.cityMysqlService = cityMysqlService;
        this.migrateMySqlToMongoDBService = migrateMySqlToMongoDBService;
    }

    @GetMapping("/migrate")
    Integer startMigration(){
        return migrateMySqlToMongoDBService.migrateCities();
    }
    // mongo db service
    @PostMapping("/mongodb/create")
    public CityMongodb createMongo(@RequestBody CityMongodb city) {
        return cityMongodbService.create(city);
    }

    @GetMapping("/mongodb/read/{id}")
    public CityMongodb readMongo(@PathVariable String id) {
        return cityMongodbService.read(id);
    }

    @GetMapping({"/mongodb/all","/mongodb/"})
    public List<CityMongodb> readAllMongo() {
        return cityMongodbService.readAll();
    }

    @PutMapping("/mongodb/update/{id}")
    public CityMongodb updateMongo(@RequestBody CityMongodb city) {
        return cityMongodbService.update(city);
    }

    @DeleteMapping("/mongodb/delete/{id}")
    public boolean deleteMongo(@PathVariable String id) {
        return cityMongodbService.delete(id);
    }

    @GetMapping("/mongodb/countries")
    public List<CityMongodb> getCountriesMongo() {

        return null;
    }

    // mysql service
    @PostMapping("/mysql/create")
    public CityMysql createMysql(@RequestBody CityMysql city) {
        return cityMysqlService.create(city);
    }

    @GetMapping("/mysql/read/{id}")
    public CityMysql readMysql(@PathVariable Long id) {
        return cityMysqlService.read(id);
    }

    @GetMapping({"/mysql/all","/mysql/"})
    public List<CityMysql> readAllMysql() {
        return cityMysqlService.readAll();
    }

    @PutMapping("/mysql/update/{id}")
    public CityMysql updateMysql(@RequestBody CityMysql city) {
        return cityMysqlService.update(city);
    }

    @DeleteMapping("/mysql/delete/{id}")
    public boolean deleteMysql(@PathVariable Long id) {
        cityMysqlService.delete(id);
        return (readMysql(id)==null);
    }

    @GetMapping("/mysql/countries")
    public List<CityMysql> getCountriesMysql() {

        return null;
    }
}
