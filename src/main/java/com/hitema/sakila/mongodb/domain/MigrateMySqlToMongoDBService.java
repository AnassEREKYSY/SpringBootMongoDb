package com.hitema.sakila.mongodb.domain;

public interface MigrateMySqlToMongoDBService {
    Integer migrateCities() ;
    Integer migrateFilms() ;
}
