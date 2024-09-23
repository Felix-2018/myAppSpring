package com.FMSv2.FMSv2.parameters.controllers;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.FMSv2.FMSv2.parameters.models.Country;
import com.FMSv2.FMSv2.parameters.models.State;
import com.FMSv2.FMSv2.parameters.services.CountryService;
import com.FMSv2.FMSv2.parameters.services.StateService;

@Controller
public class StateController {

	@Autowired private StateService stateService;
	@Autowired private CountryService countryService;

	//to reduce duplicates of state and country repitation
    public Model addModelAttribute(Model model) {
    
    	//List<State> states = stateService.findAll();
    	model.addAttribute("states",stateService.findAll());
    	model.addAttribute("countries",countryService.findAll());
    	return model;
    	
    }
	
	//Get All States
	@GetMapping("/states")
	public String findAll(Model model){
        addModelAttribute(model);
		return "parameters/states";
	}
	//Get Country by Id for state json load fields
	
		@GetMapping("/parameters/states/{id}")
		@ResponseBody
		public State getCountry(@PathVariable Integer id) {
			return stateService.findById(id);
		}
	@RequestMapping("states/findById")
	//@ResponseBody
	public State findById(Integer id)
	{
		return stateService.findById(id);
	}

	//Add State
	/*@GetMapping(value="/stateAdd")
	public String addNew(Model model) {
		List<Country> countries = countryService.findAll();
        model.addAttribute("countries",countries);
         model.addAttribute("states",new State());
         // Added Later 
         addModelAttribute(model);
		return "parameters/stateAdd";
	}
	*/
	//Fro kindson
	//Add state
	
	@GetMapping("/stateAdd")
	public String addState(Model model) {
		addModelAttribute(model);
		return "parameters/stateAdd";
	}
	
	@PostMapping(value="/states")
	public String save(State state) {
		stateService.save(state);
		return "redirect:/states";
	}
	@GetMapping(value="/stateEdit/")
	public String editCuntry(@PathVariable Integer id, Model model) {
	   	model.addAttribute("states",stateService.findAll());
    	model.addAttribute("countries",countryService.findAll());
		model.addAttribute("states" , stateService.findById(id));
		//model.addAttribute("state" , state);
		return "parameters/stateEdit";
	}

	@GetMapping(value="/stateEdit/{id}")
	public String editState(@PathVariable Integer id, Model model) {
		State state = stateService.findById(id);
		model.addAttribute("state" , state);
		return "parameters/stateEdit";
	}

	@RequestMapping(value="/state/delete/{id}", method = {RequestMethod.DELETE, RequestMethod.GET})
	public String delete(@PathVariable Integer id) {
		stateService.delete(id);
		return "redirect:/states";
	}
}
