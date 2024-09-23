package com.FMSv2.FMSv2.parameters.controllers;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.FMSv2.FMSv2.parameters.models.Country;
import com.FMSv2.FMSv2.parameters.models.Location;
import com.FMSv2.FMSv2.parameters.models.State;
import com.FMSv2.FMSv2.parameters.services.CountryService;
import com.FMSv2.FMSv2.parameters.services.LocationService;
import com.FMSv2.FMSv2.parameters.services.StateService;

@Controller
public class LocationController {

	@Autowired	private LocationService locationService;
	@Autowired	private CountryService countryService;
	@Autowired	private StateService stateService;

	
	//to reduce duplicates of state and country repitation
    public Model addModelAttribute(Model model) {
    
    	//List<State> states = stateService.findAll();
    	model.addAttribute("locations", locationService.findAll());
    	model.addAttribute("countries",countryService.findAll());
    	model.addAttribute("states", stateService.findAll());
    	return model;
    	
    }
	
	@GetMapping("/locations")
	public String findAll(Model model){
        addModelAttribute(model);
		return "parameters/locations";
	}
	//Get Country by Id for state json load fields
	
	@GetMapping("/parameters/locations/{id}")
	@ResponseBody
	public Location getLocation(@PathVariable Integer id) {
		return locationService.findById(id);
	}
	//Mine
/*
	@GetMapping(value="/locationAdd")
	public String addNew(Model model) {
		List<Country> countries = countryService.findAll();
        model.addAttribute("countries",countries);
        model.addAttribute("states",new State());
		return "parameters/locationAdd";
	}..*/
	//By Kindson Tutorial
	@GetMapping(value="/locationAdd")
	public String addLocation(Model model) {
        model.addAttribute("countries",countryService.findAll());
		return "parameters/locationAdd";
	}
		
	@GetMapping("/findById")
	@ResponseBody
	public Location findById(Integer id) {
		return locationService.findById(id);
	}

	@GetMapping("/findByDescriptionContaining/{description}")
	public List<Location> findByDescriptionContaining(@PathVariable("description") String description) {
		return locationService.findByDescriptionContaining(description);
	}

	@PostMapping("/locationsSave")
	public String save(Location location) {
		locationService.save(location);
		return "redirect:/locations";
	}

	@RequestMapping(value="/update", method = {RequestMethod.PUT, RequestMethod.GET})
	public String update(Location location) {
		locationService.save(location);
		return "redirect:/locations";
	}

	@RequestMapping(value="/delete/{id}", method = {RequestMethod.DELETE, RequestMethod.GET})
	public String deleteById(@PathVariable Integer id) {
		locationService.deleteById(id);
		return "redirect:/locations";
	}

}