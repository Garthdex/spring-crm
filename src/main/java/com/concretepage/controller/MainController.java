package com.concretepage.controller;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/main")
public class MainController {

    @RequestMapping({"/", "/index"})
    public String getMainPage(ModelMap model, Authentication authentication) {

        model.addAttribute("main", "it's main");
        return "page/main";
    }
}
