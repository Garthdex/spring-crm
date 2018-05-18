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
		//TODO validate if user already added
		service.addUser(new UserInfo(login, password));
		model.addAttribute("successMessage", "Registration successfully, please sign in");
		return "customLogin";
	}

	@RequestMapping(value="/profile")
	public String showProfile() {

		return "/view/page/profile";
	}

	@RequestMapping(value="/updateUser", method = RequestMethod.POST)
	public String updateUser(ModelMap model,
							 @RequestParam("name") String name,
							 @RequestParam("address") String address,
							 @RequestParam("phoneNumber") String phoneNumber) {
		//TODO update user from DAO

		model.addAttribute("success", "You saved the account information");
		return "/view/page/profile";
	}

	@RequestMapping(value="/error")
	public String error() {
 		return "/view/access-denied";
 	}
}	