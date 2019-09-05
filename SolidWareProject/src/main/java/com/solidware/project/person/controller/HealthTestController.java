package com.solidware.project.person.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.solidware.project.person.exception.PersonNotFoundException;
import com.solidware.project.person.exception.PersonLengthException;
import com.solidware.project.person.service.PersonService;
import com.solidware.project.person.vo.Group;
import com.solidware.project.person.vo.Person;

/**
 * Handles requests for the application home page.
 */
@RestController
public class HealthTestController {
	
	private static final Logger logger = LoggerFactory.getLogger(HealthTestController.class);
	
	@Autowired
	private PersonService personService;
		
	@RequestMapping(value = "/healthTest", method = RequestMethod.GET)
	public Person[] getPersons(Model model) {
		logger.info("HealthTestController : Get Method");
						
		Person[] persons=personService.getAllPerson();
		return persons;
	}
	
	@RequestMapping(value = "/healthTest", method = RequestMethod.POST)
	public Person addPerson(Model model, HttpServletRequest request) {
		logger.info("HealthTestController : Post Method");
		Person person = new Person();
		person.setName(request.getParameter("name"));
		//Length Limit
		if(person.getName().length()<3 || person.getName().length()>12) 
			throw new PersonLengthException(person.getName());
		
		if(personService.addPerson(person))
			return person;
		else
			return null;
	}
	
	@RequestMapping(value = "/healthTest/{healthData}", method = RequestMethod.DELETE)
	public String deletePerson(Model model, @PathVariable("healthData") String personName) {
		logger.info("HealthTestController : DELETE Method");
						
		if(personService.deletePerson(personName))
			return personName;
		else
			throw new PersonNotFoundException(personName);
	}
	
	@RequestMapping(value = "/healthTest/{groupSize}/{sizeLimit}", method = RequestMethod.GET)
	public Group[] dividePerson(Model model, @PathVariable("groupSize") int groupSize,
			@PathVariable("sizeLimit") int sizeLimit) {
		logger.info("HealthTestController : Get Method");
		
		return personService.getRandom(groupSize, sizeLimit);
	}
	
}
