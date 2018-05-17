package com.concretepage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.concretepage.service.IUserService;

@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	private  IUserService service;
	@RequestMapping(value="/home")
	public String home(ModelMap model, Authentication authentication) {
		authentication.getPrincipal();
		model.addAttribute("main", "it's main");
 		return "main";
 	}
	@RequestMapping(value="/register")
	public String register(ModelMap model, Authentication authentication) {

		return "registration";
	}
	@RequestMapping(value="/error")
	public String error() {
 		return "page/access-denied";
 	}
}	