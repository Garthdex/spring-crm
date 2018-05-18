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
	public String home(ModelMap model) {
 		return "customLogin";
 	}

	@RequestMapping(value="/register", method = RequestMethod.POST)
	public String register(ModelMap model,
			               @RequestParam("registerLogin") String login,
						   @RequestParam("registerPassword") String password) {
		if (service.getDataByUserName(login) != null) {
			model.addAttribute("errorMessageRegistration", "User with such login already exist, pls try again");
		} else {
			service.addUser(new UserInfo(login, password));
			model.addAttribute("successMessage", "Registration successfully, please sign in");
		}
		return "customLogin";

	}

	@RequestMapping(value="/profile")
	public String showProfile(ModelMap model, Authentication authentication) {
		authentication.getPrincipal();
		model.addAttribute("user", service.getDataByUserName(authentication.getName()));
		return "/view/page/profile";
	}

	@RequestMapping(value="/updateUser", method = RequestMethod.POST)
	public String updateUser(ModelMap model, Authentication authentication,
							 @RequestParam("id") Integer id,
							 @RequestParam("name") String name,
							 @RequestParam("address") String address,
							 @RequestParam("phoneNumber") String phoneNumber) {
		service.updateUser(id, name, address, phoneNumber);

		model.addAttribute("successMessage", "You saved the account information");
		model.addAttribute("user", service.getDataByUserName(authentication.getName()));
		return "/view/page/profile";
	}

	@RequestMapping(value="/error")
	public String error() {
 		return "/view/access-denied";
 	}
}	