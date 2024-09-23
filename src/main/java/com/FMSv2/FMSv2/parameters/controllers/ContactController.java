package com.FMSv2.FMSv2.parameters.controllers;

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

import com.FMSv2.FMSv2.parameters.models.Contact;
import com.FMSv2.FMSv2.parameters.models.Country;
import com.FMSv2.FMSv2.parameters.models.State;
import com.FMSv2.FMSv2.parameters.services.ContactService;
import com.FMSv2.FMSv2.parameters.services.CountryService;
//import com.FMSv2.FMSv2.hr.services.EmployeeTypeService;
//import com.FMSv2.FMSv2.hr.services.JobTitleService;
import com.FMSv2.FMSv2.parameters.services.StateService;

@Controller
public class ContactController {

	@Autowired private StateService stateService;
	@Autowired private CountryService countryService;
	@Autowired private ContactService contactService;

	//Get All Contacts
	@GetMapping("/contacts")
	public String findAll(Model model){
		model.addAttribute("countries", countryService.findAll());
		model.addAttribute("states", stateService.findAll());
		model.addAttribute("contacts", contactService.findAll());
		return "parameters/contacts";
	}

	@RequestMapping("contacts/findById")
	public Contact getContact(@PathVariable Integer id)
	{
		return contactService.getById(id);
	}
	//Get Country by Id for state json load fields
	
	@GetMapping("/parameters/contacts/{id}")
	@ResponseBody
	public Contact getContacts(@PathVariable Integer id) {
		return contactService.getById(id);
	}
	//Add Contact
	@GetMapping(value="/contactAdd")
	public String addNewContact(Contact Contact) {
		//countryService.save(country);
		return "parameters/contactAdd";
	}
	//Save Contact
	@PostMapping(value="/contacts")
	public String addNew(Contact contact) {
		contactService.save(contact);
		return "redirect:/contacts";
	}
	//Contact EDit
	@GetMapping(value="/contactEdit/{id}")
	public String editContact(@PathVariable Integer id, Model model) {
		Contact contact = contactService.getById(id);
		model.addAttribute("contact" , contact);
		return "parameters/contactEdit";
	}

	@RequestMapping(value="/contacts/delete/{id}", method = {RequestMethod.DELETE, RequestMethod.GET})
	public String delete(@PathVariable Integer id) {
		contactService.delete(id);
		return "redirect:/contacts";
	}

}
