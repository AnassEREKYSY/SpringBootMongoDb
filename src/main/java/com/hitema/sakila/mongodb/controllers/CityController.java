package com.hitema.sakila.mongodb.controllers;


import com.hitema.sakila.mongodb.models.City;
import com.hitema.sakila.mongodb.services.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cities")
public class CityController {
    CityService cityService;
    @Autowired
    public CityController(CityService cityService) {
        this.cityService = cityService;
    }
    @PostMapping("/create")
    public City create(@RequestBody City city) {
        return cityService.create(city);
    }

    @GetMapping("/read/{id}")
    public City read(@PathVariable String id) {
        return cityService.read(id);
    }

    @GetMapping({"/all","/"})
    public List<City> readAll() {
        return cityService.readAll();
    }

    @PutMapping("/update/{id}")
    public City update(@RequestBody City city) {
        return cityService.update(city);
    }

    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable String id) {
        cityService.delete(id);
        return (read(id)==null);
    }
}
