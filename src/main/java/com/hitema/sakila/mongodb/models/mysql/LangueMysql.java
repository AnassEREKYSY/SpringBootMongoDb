package com.hitema.sakila.mongodb.models.mysql;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "langue")
public class LangueMysql {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="langue_id")
    private Long id;

    @Column(name="name")
    private String name;


    @OneToMany(mappedBy = "langueMysql")
    @JsonIgnoreProperties(value = { "langueMysql" })
    private List<FilmMysql> filmMysqlList;


    @Column(name="last_update")
    private LocalDateTime lastUpdate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<FilmMysql> getFilmMysqlList() {
        return filmMysqlList;
    }

    public void setFilmMysqlList(List<FilmMysql> filmMysqlList) {
        this.filmMysqlList = filmMysqlList;
    }

    public LocalDateTime getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(LocalDateTime lastUpdate) {
        this.lastUpdate = lastUpdate;
    }
}
