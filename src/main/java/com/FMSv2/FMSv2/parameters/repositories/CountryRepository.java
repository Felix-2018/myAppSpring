package com.FMSv2.FMSv2.parameters.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.FMSv2.FMSv2.parameters.models.Country;

@Repository
public interface CountryRepository extends JpaRepository<Country, Integer> {

}
