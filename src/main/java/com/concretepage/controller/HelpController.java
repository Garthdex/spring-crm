package com.concretepage.controller;

import com.concretepage.entity.Help;
import com.concretepage.service.HelpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelpController {
    @Autowired
    HelpService helpService;

    @RequestMapping(value = "/saveHelp", method = RequestMethod.POST)
    @ResponseBody
    public Help saveHelpAjax(@RequestParam("phoneNumber") String phoneNumber, @RequestParam("message") String message) {
        return helpService.saveHelp(new Help(phoneNumber, message));
    }

    @RequestMapping(value = "/help")
    @ResponseBody
    public ModelAndView showHelpAjax() {

        return new ModelAndView( "/view/component/help" );
    }
}
