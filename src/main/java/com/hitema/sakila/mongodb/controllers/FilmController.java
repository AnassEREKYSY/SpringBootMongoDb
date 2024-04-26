package com.hitema.sakila.mongodb.controllers;

import com.hitema.sakila.mongodb.domain.MigrateMySqlToMongoDBService;
import com.hitema.sakila.mongodb.models.mongodb.FilmMongodb;
import com.hitema.sakila.mongodb.models.mysql.FilmMysql;
import com.hitema.sakila.mongodb.services.mongodb.FilmMongodbService;
import com.hitema.sakila.mongodb.services.mysql.FilmMysqlService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/films")
public class FilmController {

    private FilmMysqlService filmMysqlService;
    private FilmMongodbService filmMongodbService;

    private final MigrateMySqlToMongoDBService migrateMySqlToMongoDBService;

    public FilmController(FilmMysqlService filmMysqlService, FilmMongodbService filmMongodbService, MigrateMySqlToMongoDBService migrateMySqlToMongoDBService) {
        this.filmMysqlService = filmMysqlService;
        this.filmMongodbService = filmMongodbService;
        this.migrateMySqlToMongoDBService = migrateMySqlToMongoDBService;
    }


    @GetMapping("/migrate")
    Integer startMigration(){
        return 1;
    }

    //Mysql service

    @PostMapping("/mysql/create")
    public FilmMysql createMysql(@RequestBody FilmMysql filmMysql) {
        return filmMysqlService.create(filmMysql);
    }

    @GetMapping("/mysql/read/{id}")
    public FilmMysql readMysql(@PathVariable Long id) {
        return filmMysqlService.read(id);
    }

    @GetMapping({"/mysql/all","/mysql/"})
    public List<FilmMysql> readAllMysql() {
        return filmMysqlService.readAll();
    }

    @PutMapping("/mysql/update/{id}")
    public FilmMysql updateMysql(@RequestBody FilmMysql filmMysql) {
        return filmMysqlService.update(filmMysql);
    }

    @DeleteMapping("/mysql/delete/{id}")
    public boolean deleteMysql(@PathVariable Long id) {
        return filmMysqlService.delete(id);
    }


    //MongodbService
    @PostMapping("/mongodb/create")
    public FilmMongodb createMongo(@RequestBody FilmMongodb filmMongodb) {
        return filmMongodbService.create(filmMongodb);
    }

    @GetMapping("/mongodb/read/{id}")
    public FilmMongodb readMongo(@PathVariable String id) {
        return filmMongodbService.read(id);
    }

    @GetMapping({"/mongodb/all","/mongodb/"})
    public List<FilmMongodb> readAllMongo() {
        return filmMongodbService.readAll();
    }

    @PutMapping("/mongodb/update/{id}")
    public FilmMongodb updateMongo(@RequestBody FilmMongodb filmMongodb) {
        return filmMongodbService.update(filmMongodb);
    }

    @DeleteMapping("/mongodb/delete/{id}")
    public boolean deleteMongo(@PathVariable String id) {
        return filmMongodbService.delete(id);
    }

}
