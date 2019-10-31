package com.solidware.project.titanic.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

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
		member.setPclass(Integer.valueOf(request.getParameter("Pclass")));
		member.setFare(Float.valueOf(request.getParameter("Fare")));
		member.setEmbarked(request.getParameter("Embarked"));
		member.setParch(Integer.valueOf(request.getParameter("Parch")));
		member.setAge(Integer.valueOf(request.getParameter("Age")));
		member.setCabin(request.getParameter("Cabin"));
		member.setName(request.getParameter("Name"));
		member.setPassengerId(request.getParameter("PassengerId"));
		member.setSibSp(Integer.valueOf(request.getParameter("SibSp")));
		SimpleDateFormat format1 = new SimpleDateFormat("yyyyMMdd");
		Date time = new Date();
		member.setRgsDt(format1.format(time));
		member.setSurvived(2);
		try {
			double percent = (double)titanicService.getLivePercentExpectation(member).get("Survived");
			System.out.println("percent : "+ percent*100);
			model.addAttribute("livePercent", Math.round(percent*1000000)/(double)10000);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		titanicService.addMember(member);
		
		return "livePercent";
	}
}
