package com.jwt.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/countries")
public class CountryController {

    @GetMapping
    public String getCountries() {

        return "Access Granted! JWT Authentication Successful.";

    }

}