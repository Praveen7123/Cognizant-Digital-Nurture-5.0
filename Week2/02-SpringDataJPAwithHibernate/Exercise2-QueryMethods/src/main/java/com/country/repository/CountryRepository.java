package com.country.repository;

import com.country.entity.Country;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CountryRepository extends JpaRepository<Country, String> {

    Optional<Country> findByCode(String code);

    List<Country> findByName(String name);

}