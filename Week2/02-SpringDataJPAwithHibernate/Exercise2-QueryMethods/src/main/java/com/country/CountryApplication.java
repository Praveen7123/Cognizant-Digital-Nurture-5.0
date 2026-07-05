package com.country;

import com.country.service.CountryService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CountryApplication {

    public static void main(String[] args) {
        SpringApplication.run(CountryApplication.class, args);
    }

    @Bean
    CommandLineRunner runner(CountryService service) {

    return args -> {
            System.out.println("All Countries");

            service.getCountries().forEach(System.out::println);

            System.out.println();

            System.out.println("Country by Code");

            System.out.println(service.getCountryByCode("IN"));

            System.out.println();

            System.out.println("Country by Name");

            service.getCountryByName("India")
                   .forEach(System.out::println);
        };

    }

}