package com.solidware.project.person.controller;

import java.nio.file.AccessDeniedException;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.WebAttributes;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Handles requests for the application home page.
 */

@Controller
public class LoginController {
	
	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String homePage(Model model) {
		logger.info("LoginController : GET Method");
		
		return "index";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(Model model,
			@RequestParam(value="error", required=false) String error, 
            @RequestParam(value="logout", required=false) String logout
			) {
		logger.info("LoginController : POST Method");
						
		if(error != null) {
            model.addAttribute("errorMsg", "Invalid username and password");
            logger.info("LoginController : Invalid username and password");
        }
        if(logout != null) {
            model.addAttribute("logoutMsg", "You have been logged out successfully");
            logger.info("LoginController : You have been logged out successfully");
        }
        logger.info("LoginController : POST Method2");
		return "personList";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(Model model) {
		logger.info("LoginController : GET Method");
		
		return "login";
	}
}
