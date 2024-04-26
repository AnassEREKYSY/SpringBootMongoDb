package com.hitema.sakila.mongodb.services.mysql;

import com.hitema.sakila.mongodb.models.mysql.CityMysql;
import com.hitema.sakila.mongodb.models.mysql.CountryMysql;

import java.util.List;

public interface CityMysqlService {
    CityMysql create(CityMysql city);
    List<CityMysql> readAll();
    List<CountryMysql> getAll();
    CityMysql read(Long id);
    CityMysql update(CityMysql city);
    Boolean delete(Long id);
}
