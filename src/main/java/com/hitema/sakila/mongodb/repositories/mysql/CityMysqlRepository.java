package com.hitema.sakila.mongodb.repositories.mysql;

import com.hitema.sakila.mongodb.models.mysql.CityMysql;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CityMysqlRepository extends JpaRepository<CityMysql,Long> {
    List<CityMysql> findCitiesByNameContaining(String expr);
    List<CityMysql> findCitiesByCapitalTrue();
}

