package com.country.controller;

import com.country.entity.Country;
import com.country.service.CountryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/countries")
public class CountryController {

    private final CountryService service;

    public CountryController(CountryService service) {
        this.service = service;
    }

    @GetMapping
    public List<Country> getAllCountries() {
        return service.getCountries();
    }

    @GetMapping("/{code}")
    public Country getCountry(@PathVariable String code) {
        return service.getCountryByCode(code);
    }

    @PostMapping
    public Country addCountry(@RequestBody Country country) {
        return service.addCountry(country);
    }

    @PutMapping("/{code}")
    public Country updateCountry(@PathVariable String code,
                                 @RequestBody Country country) {
        return service.updateCountry(code, country);
    }

    @DeleteMapping("/{code}")
    public String deleteCountry(@PathVariable String code) {

        service.deleteCountry(code);

        return "Country deleted successfully.";

    }

}