package com.hitema.sakila.mongodb.models.mysql;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name="city")
public class CityMysql {
    @Id
        @GeneratedValue(strategy= GenerationType.IDENTITY)
        @Column(name="city_id")
    private Long id;

    @Column(name="city")
    private String name;


    private Boolean capital;


    @ManyToOne
        @JoinColumn(name = "country_id")
        @JsonIgnoreProperties(value = { "cities" })
    private CountryMysql country;

    @Column(name="last_update")
    private LocalDateTime lastUpdate ;


    public CountryMysql getCountry() {
        return country;
    }

    public void setCountry(CountryMysql country) {
        this.country = country;
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

    public Boolean getCapital() {
        return capital;
    }

    public void setCapital(Boolean capital) {
        this.capital = capital;
    }

}
