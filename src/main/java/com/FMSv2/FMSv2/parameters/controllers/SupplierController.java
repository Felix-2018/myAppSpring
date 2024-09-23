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

import com.FMSv2.FMSv2.parameters.models.Country;
import com.FMSv2.FMSv2.parameters.models.Location;
import com.FMSv2.FMSv2.parameters.models.State;
import com.FMSv2.FMSv2.parameters.models.Supplier;
import com.FMSv2.FMSv2.parameters.services.CountryService;
import com.FMSv2.FMSv2.parameters.services.StateService;
import com.FMSv2.FMSv2.parameters.services.SupplierService;

@Controller
public class SupplierController {

	@Autowired private StateService stateService;
	@Autowired private CountryService countryService;
	@Autowired private SupplierService supplierService;

	//Get All Suppliers
	@GetMapping("/suppliers")
	public String findAll(Model model){
		model.addAttribute("countries", countryService.findAll());
		model.addAttribute("states", stateService.findAll());
		model.addAttribute("suppliers", supplierService.findAll());
		return "/parameters/suppliers";
	}
	//Get Country by Id for state json load fields
	
	@GetMapping("/parameters/suppliers/{id}")
	@ResponseBody
	public Supplier getCountry(@PathVariable Integer id) {
		return supplierService.findById(id);
	}
	@RequestMapping("suppliers/findById")
	@ResponseBody
	public Supplier findById(Integer id)
	{
		return supplierService.findById(id);
	}

	//Add Supplier
	  //AddClient
		@GetMapping(value="/supplierAdd")
		public String addNew(Model model) {
			List<Country> countries = countryService.findAll();
	        model.addAttribute("countries",countries);
	         model.addAttribute("states",new State());
	         // Added Later 
			return "parameters/supplierAdd";
		}

		@PostMapping("/supplierSave")
		public String save(Supplier supplier) {
			supplierService.save(supplier);
			return "redirect:/suppliers";
		}

	@RequestMapping(value="suppliers/update", method = {RequestMethod.PUT, RequestMethod.GET})
	public String update(Supplier supplier) {
		supplierService.save(supplier);
		return "redirect:/suppliers";
	}

	@RequestMapping(value="/suppliers/delete/{id}", method = {RequestMethod.DELETE, RequestMethod.GET})
	public String delete(Integer id) {
		supplierService.delete(id);
		return "redirect:/suppliers";
	}


}
