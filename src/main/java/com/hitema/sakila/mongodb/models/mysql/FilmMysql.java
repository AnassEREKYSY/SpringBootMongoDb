package com.hitema.sakila.mongodb.models.mysql;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.time.Year;

@Entity
@Table(name = "film")
public class FilmMysql {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="film_id")
    private Long id;

    @Column(name="title")
    private String title;

    @Column(name="release_year")
    private Year releaseYear;

    @Column(name="last_update")
    private LocalDateTime lastUpdate;

    @ManyToOne
        @JoinColumn(name = "language_id")
        @JsonIgnoreProperties(value = { "films" })
    private LangueMysql langueMysql;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Year getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(Year releaseYear) {
        this.releaseYear = releaseYear;
    }

    public LocalDateTime getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(LocalDateTime lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public LangueMysql getLangueMysql() {
        return langueMysql;
    }

    public void setLangueMysql(LangueMysql langueMysql) {
        this.langueMysql = langueMysql;
    }
}
