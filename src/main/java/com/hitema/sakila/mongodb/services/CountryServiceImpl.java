package com.hitema.sakila.mongodb.services;

import com.hitema.sakila.mongodb.models.Country;
import com.hitema.sakila.mongodb.repositories.CountryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryServiceImpl implements CountryService {
    CountryRepository countryRepository;
    public CountryServiceImpl(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }
    @Override
    public Country create(Country country) {
        return this.countryRepository.save(country);
    }

    @Override
    public List<Country> readAll() {
        return this.countryRepository.findAll();
    }

    @Override
    public Country read(String id) {
        return this.countryRepository.findById(id).orElse(null);
    }

    @Override
    public Country update(Country country) {
        return this.countryRepository.save(country);
    }

    @Override
    public Boolean delete(String id) {
        this.countryRepository.deleteById(id);
        return (read(id) == null);
    }
}
