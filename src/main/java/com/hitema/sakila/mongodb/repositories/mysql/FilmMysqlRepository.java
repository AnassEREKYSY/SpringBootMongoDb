package com.hitema.sakila.mongodb.repositories.mysql;

import com.hitema.sakila.mongodb.models.mysql.FilmMysql;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FilmMysqlRepository extends JpaRepository<FilmMysql,Long> {
}
