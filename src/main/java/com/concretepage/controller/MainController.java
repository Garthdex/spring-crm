package com.concretepage.controller;

import com.concretepage.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/main")
public class MainController {
    @Autowired
    private IUserService service;

    @RequestMapping({"/", "/index"})
    public String getMainPage(ModelMap model, Authentication authentication) {
        if(authentication != null) {
            authentication.getPrincipal();
            model.addAttribute("user", service.getDataByUserName(authentication.getName()));
        }

        return "/view/page/main";
    }
}
