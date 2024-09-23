package com.FMSv2.FMSv2.parameters.controllers;

import java.util.List;
//import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.FMSv2.FMSv2.parameters.models.Country;
import  com.FMSv2.FMSv2.parameters.services.CountryService;


@Controller
public class CountryController {

	@Autowired private CountryService countryService;

	//Get All Countries
	@GetMapping("/countries")
	public String getAll(Model model){
		List<Country> countries = countryService.findAll();
		model.addAttribute("countries", countries);
		return "parameters/countryList";
	}
//Get Country by Id for state json load fields
	
	@GetMapping("/parameters/countries/{id}")
	@ResponseBody
	public Country getCountry(@PathVariable Integer id) {
		return countryService.getById(id);
	}
	
	
	//Add Country
	@GetMapping(value="/countryAdd")
	public String addNew(Country country) {
		//countryService.save(country);
		return "parameters/countryAdd";
	}
	//Save CountryAdd
	@PostMapping(value="/countries")
	public String save(Country country) {
		countryService.save(country);
		return "redirect:/countries";
	}

	@GetMapping(value="/countryEdit/{id}")
	public String editCuntry(@PathVariable Integer id, Model model) {
		Country country = countryService.getById(id);
		model.addAttribute("country" , country);
		return "parameters/countryEdit";
		//return "redirect:/countries";
	}
	@RequestMapping(value="/countries/update/?id={id}", method = {RequestMethod.PUT, RequestMethod.GET})
	public String ediCuntry(@PathVariable Integer id, Model model) {
		Country country = countryService.getById(id);
		model.addAttribute("country" , country);
		return "redirect:/countries";
	}

	@RequestMapping(value="/countries/delete/{id}", method = {RequestMethod.DELETE, RequestMethod.GET})
	public String delete(@PathVariable Integer id) {
		countryService.delete(id);
		return "redirect:/countries";
	}
}
