package com.hitema.sakila.mongodb.services.mysql;

import com.hitema.sakila.mongodb.models.mysql.CityMysql;
import com.hitema.sakila.mongodb.models.mysql.CountryMysql;
import com.hitema.sakila.mongodb.models.mysql.FilmMysql;

import java.util.List;

public interface FilmMysqlService {

    FilmMysql create(FilmMysql filmMysql);
    List<FilmMysql> readAll();
    FilmMysql read(Long id);
    FilmMysql update(FilmMysql filmMysql);
    Boolean delete(Long id);
}
