package com.hitema.sakila.mongodb.services.mysql;

import com.hitema.sakila.mongodb.models.mysql.FilmMysql;
import com.hitema.sakila.mongodb.repositories.mysql.FilmMysqlRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FilmMysqlServiceImpl implements FilmMysqlService {

    FilmMysqlRepository filmMysqlRepository;
    public FilmMysqlServiceImpl(FilmMysqlRepository filmMysqlRepository) {
        this.filmMysqlRepository = filmMysqlRepository;
    }
    @Override
    public FilmMysql create(FilmMysql filmMysql) {
        return this.filmMysqlRepository.save(filmMysql);
    }

    @Override
    public List<FilmMysql> readAll() {
        return this.filmMysqlRepository.findAll();
    }

    @Override
    public FilmMysql read(Long id) {
        return this.filmMysqlRepository.findById(id).orElse(null);
    }

    @Override
    public FilmMysql update(FilmMysql filmMysql) {
        return this.filmMysqlRepository.save(filmMysql);
    }

    @Override
    public Boolean delete(Long id) {
        this.filmMysqlRepository.deleteById(id);
        return (this.read(id) == null);
    }
}
