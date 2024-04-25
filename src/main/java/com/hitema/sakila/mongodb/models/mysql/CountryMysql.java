package com.hitema.sakila.mongodb.models.mysql;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "country")
public class CountryMysql {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="country_id")
    private Long id;

    @Column(name="country")
    private String name;


    @OneToMany(mappedBy = "country")
    @JsonIgnoreProperties(value = { "country" })
    private List<CityMysql> cities;


    @Column(name="last_update")
    private LocalDateTime lastUpdate;

    public List<CityMysql> getCities() {
        return cities;
    }

    public void setCities(List<CityMysql> cities) {
        this.cities = cities;
    }

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

    public LocalDateTime getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(LocalDateTime lastUpdate) {
        this.lastUpdate = lastUpdate;
    }
}
