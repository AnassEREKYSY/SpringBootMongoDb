package com.hitema.sakila.mongodb.services.mongodb;

import com.hitema.sakila.mongodb.models.mongodb.FilmMongodb;
import com.hitema.sakila.mongodb.repositories.mongodb.FilmMongodbRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FilmMongodbServiceImpl implements FilmMongodbService {
    FilmMongodbRepository filmMongodbRepository;

    public FilmMongodbServiceImpl(FilmMongodbRepository filmMongodbRepository) {
        this.filmMongodbRepository = filmMongodbRepository;
    }


    @Override
    public FilmMongodb create(FilmMongodb filmMongodb) {
        return this.filmMongodbRepository.save(filmMongodb);
    }

    @Override
    public List<FilmMongodb> readAll() {
        return this.filmMongodbRepository.findAll();
    }

    @Override
    public FilmMongodb read(String id) {
        return this.filmMongodbRepository.findById(id).orElse(null);
    }

    @Override
    public FilmMongodb update(FilmMongodb filmMongodb) {
        return this.filmMongodbRepository.save(filmMongodb);
    }

    @Override
    public Boolean delete(String id) {
        this.filmMongodbRepository.deleteById(id);
        return (this.read(id)==null);
    }
}
