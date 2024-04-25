package com.hitema.sakila.mongodb.services.mysql;

import com.hitema.sakila.mongodb.models.mysql.CityMysql;

import java.util.List;

public interface CityMysqlService {
    CityMysql create(CityMysql city);
    List<CityMysql> readAll();
    CityMysql read(Long id);
    CityMysql update(CityMysql city);
    Boolean delete(Long id);
}
