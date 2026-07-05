package com.country.service;

import com.country.entity.Country;
import com.country.repository.CountryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryService {

    private final CountryRepository repository;

    public CountryService(CountryRepository repository) {
        this.repository = repository;
    }
    public Country getCountryByCode(String code) {

    return repository.findByCode(code).orElse(null);
    }


    public List<Country> getCountries() {
        return repository.findAll();
    }
    public List<Country> getCountryByName(String name){

    return repository.findByName(name);
    }
}