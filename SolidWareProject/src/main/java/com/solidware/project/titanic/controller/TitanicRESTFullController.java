package com.solidware.project.titanic.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.solidware.project.titanic.service.TitanicService;
import com.solidware.project.titanic.vo.TitanicMember;

/**
 * Handles requests for the application home page.
 */
@RestController
public class TitanicRESTFullController {
	
	private static final Logger logger = LoggerFactory.getLogger(TitanicRESTFullController.class);
	
	@Autowired
	private TitanicService titanicService;
		
	
	@RequestMapping(value = "/titanic/restful", method = RequestMethod.POST)
	public Map<String, Object> getLivePercent(Model model, HttpServletRequest request) {
		logger.info("TitanicRESTFullController : Post Method");
		TitanicMember member = new TitanicMember();
		Map<String, Object> expectation = null;
		
		member.setSex(request.getParameter("Sex"));
		member.setPclass(request.getParameter("Pclass"));
		member.setFare(request.getParameter("Fare"));
		member.setEmbarked(request.getParameter("Embarked"));
		member.setParch(request.getParameter("Parch"));
		member.setAge(request.getParameter("Age"));
		member.setCabin(request.getParameter("Cabin"));
		member.setName(request.getParameter("Name"));
		member.setPassengerId(request.getParameter("PassengerId"));
		member.setSibSp(request.getParameter("SibSp"));
		try {
			expectation = titanicService.getLivePercentExpectation(member);
			System.out.println("expectation value : "+ expectation.toString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return expectation;
	}
	
	//Json API용
	/*@RequestMapping(value = "/person", method = RequestMethod.POST)
	public Person addPerson(Model model, @RequestBody Person person) {
		logger.info("PersonRESTFullController : Post Method");
		
		//Length Limit
		if(person.getName().length()<3 || person.getName().length()>12) 
			throw new PersonLengthException(person.getName());
		
		if(personService.addPerson(person))
			return person;
		else
			return null;
	}*/
	
}
