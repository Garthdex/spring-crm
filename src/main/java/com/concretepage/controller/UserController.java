package com.concretepage.controller;

import com.concretepage.entity.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.concretepage.service.IUserService;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {
	@Autowired
	private  IUserService service;

	@RequestMapping(value="/login")
	public String home(ModelMap model, Authentication authentication) {
 		return "customLogin";
 	}

	@RequestMapping(value="/register", method = RequestMethod.POST)
	public String register(ModelMap model,
			               @RequestParam("registerLogin") String login,
						   @RequestParam("registerPassword") String password) {
		service.addUser(new UserInfo(login, password));
		model.addAttribute("successMessage", "Registration successfully, please sign in.");
		return "customLogin";
	}

	@RequestMapping(value="/error")
	public String error() {
 		return "/view/access-denied";
 	}
}	