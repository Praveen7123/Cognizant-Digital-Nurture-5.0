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

    public List<Country> getCountries() {
        return repository.findAll();
    }

    public Country getCountryByCode(String code) {
        return repository.findById(code).orElse(null);
    }

    public Country addCountry(Country country) {
        return repository.save(country);
    }

    public Country updateCountry(String code, Country country) {

        Country existing = repository.findById(code).orElse(null);

        if (existing != null) {
            existing.setName(country.getName());
            return repository.save(existing);
        }

        return null;
    }

    public void deleteCountry(String code) {
        repository.deleteById(code);
    }

}