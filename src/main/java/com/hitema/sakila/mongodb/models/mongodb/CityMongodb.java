package com.hitema.sakila.mongodb.models.mongodb;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "city")
public class CityMongodb {
    @Id
    private String id;
    @Field("city_name")
    private String cityName;
    @Field("capital")
    private boolean capital;
    @DBRef
    private CountryMongodb country;

    public CityMongodb(String id, String cityName, Boolean capital, CountryMongodb country) {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public CountryMongodb getCountry() {
        return country;
    }

    public void setCountry(CountryMongodb country) {
        this.country = country;
    }

    public boolean isCapital() {
        return capital;
    }

    public void setCapital(boolean capital) {
        this.capital = capital;
    }
}
