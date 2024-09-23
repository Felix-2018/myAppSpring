package com.FMSv2.FMSv2.parameters.services;

import java.util.List;
//import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import  com.FMSv2.FMSv2.parameters.models.Country;
import  com.FMSv2.FMSv2.parameters.repositories.CountryRepository;

@Service
@Transactional
public class CountryService {

	@Autowired
	private CountryRepository countryRepository;

	//Get All Countrys
	public List<Country> findAll(){
		return countryRepository.findAll();

	}

	//Get Country By Id

		
		public Country getById(Integer id) {
			// TODO Auto-generated method stub
			return countryRepository.findById(id).orElse(null);
		}


	//Delete Country
	public void delete(int id) {
		countryRepository.deleteById(id);
	}

	//Update Country
	public void save( Country country) {
		countryRepository.save(country);
	}


}