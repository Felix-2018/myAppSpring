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
import org.springframework.web.bind.annotation.ResponseBody;

import com.FMSv2.FMSv2.parameters.models.Client;
import com.FMSv2.FMSv2.parameters.models.Country;
import com.FMSv2.FMSv2.parameters.models.State;
import com.FMSv2.FMSv2.parameters.services.ClientService;
import com.FMSv2.FMSv2.parameters.services.CountryService;
//import com.FMSv2.FMSv2.hr.services.EmployeeTypeService;
//import com.FMSv2.FMSv2.hr.services.JobTitleService;
import com.FMSv2.FMSv2.parameters.services.StateService;

@Controller
public class ClientController {

	@Autowired private StateService stateService;
	@Autowired private CountryService countryService;
	@Autowired private ClientService clientService;

	//Get All Clients
	@GetMapping("/clients")
	public String findAll(Model model){
		model.addAttribute("countries", countryService.findAll());
		model.addAttribute("states", stateService.findAll());
		model.addAttribute("clients", clientService.findAll());
		return "/parameters/clients";
	}
	//Get Country by Id for state json load fields
	
	@GetMapping("/parameters/clients/{id}")
	@ResponseBody
	public Client getCountry(@PathVariable Integer id) {
		return clientService.findById(id);
	}
	@RequestMapping("clients/findById")
	@ResponseBody
	public Client findById(Integer id)
	{
		return clientService.findById(id);
	}
  //AddClient
	@GetMapping(value="/clientAdd")
	public String addNew(Model model) {
		List<Country> countries = countryService.findAll();
        model.addAttribute("countries",countries);
         model.addAttribute("states",new State());
         // Added Later 
		return "parameters/clientAdd";
	}
	//Save Client
	@PostMapping(value="/clients")
	public String save(Client client) {
		clientService.save(client);
		return "redirect:/clients";
	}
	@RequestMapping(value="clients/delete/{id}", method = {RequestMethod.DELETE, RequestMethod.GET})
	public String delete(Integer id) {
		clientService.delete(id);
		return "redirect:/clients";
	}

}
