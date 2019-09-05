package com.solidware.project.titanic.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.solidware.project.titanic.service.TitanicService;
import com.solidware.project.titanic.vo.TitanicMember;

/**
 * Handles requests for the application home page.
 */
@Controller
public class TitanicController {
	
	private static final Logger logger = LoggerFactory.getLogger(TitanicController.class);
	
	@Autowired
	private TitanicService titanicService;
		
	@RequestMapping(value = "/titanic", method = RequestMethod.GET)
	public String getTitanic(Model model) {
		logger.info("TitanicController : Get Method");
		
		return "index";
	}
	
	@RequestMapping(value = "/titanic", method = RequestMethod.POST)
	public String getLivePercent(Model model, HttpServletRequest request) {
		logger.info("TitanicController : Post Method");
		TitanicMember member = new TitanicMember();
		
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
			double percent = (double)titanicService.getLivePercentExpectation(member).get("Survived");
			System.out.println("percent : "+ percent*100);
			model.addAttribute("livePercent", Math.round(percent*1000000)/(double)10000);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "livePercent";
	}
}
