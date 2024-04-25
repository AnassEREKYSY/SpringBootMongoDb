package com.hitema.sakila.mongodb.controllers;

import com.hitema.sakila.mongodb.models.Country;
import com.hitema.sakila.mongodb.services.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/countries")
public class CountryController {
    CountryService countryService;
    @Autowired
    public CountryController(CountryService countryService) {
        this.countryService = countryService;
    }
    @PostMapping("/create")
    public Country create(@RequestBody Country country) {
        return countryService.create(country);
    }

    @GetMapping("/read/{id}")
    public Country read(@PathVariable String id) {
        return countryService.read(id);
    }

    @GetMapping({"/all","/"})
    public List<Country> readAll() {
        return countryService.readAll();
    }

    @PutMapping("/update/{id}")
    public Country update(@RequestBody Country country) {
        return countryService.update(country);
    }

    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable String id) {
        countryService.delete(id);
        return (read(id)==null);
    }
}
