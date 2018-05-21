package com.concretepage.controller;

import com.concretepage.entity.Request;
import com.concretepage.entity.Service;
import com.concretepage.entity.UserInfo;
import com.concretepage.service.IUserService;
import com.concretepage.service.RequestService;
import com.concretepage.service.ServiceDAOService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ServiceController {
    private static final String PENDING = "pending";
    private static final String SUCCESS_MESSAGE = "You have successfully applied the request. Manager will contact you by phone for further information";
    @Autowired
    private ServiceDAOService service;
    @Autowired
    private IUserService userService;
    @Autowired
    private RequestService requestService;

    @RequestMapping(value = "/internet")
    @ResponseBody
    public ModelAndView getInternetServices(ModelMap model) {
        model.addAttribute("services", service.getServicesByType("internet"));
        return new ModelAndView( "/view/component/services" );
    }

    @RequestMapping(value = "/tv")
    @ResponseBody
    public ModelAndView getTvServices(ModelMap model) {
        model.addAttribute("services", service.getServicesByType("tv"));
        return new ModelAndView( "/view/component/services" );
    }

    @RequestMapping(value = "/phone")
    @ResponseBody
    public ModelAndView getPhoneServices(ModelMap model) {
        model.addAttribute("services", service.getServicesByType("phone"));
        return new ModelAndView( "/view/component/services" );
    }

    @RequestMapping(value = "/buyService", method = RequestMethod.POST)
    @ResponseBody
    public ModelAndView getAddRequestForm(ModelMap model, Authentication authentication,
                                          @RequestParam("serviceId") Integer serviceId,
                                          @RequestParam("serviceName") String serviceName,
                                          @RequestParam("serviceType") String serviceType,
                                          @RequestParam("servicePrice") double servicePrice,
                                          @RequestParam("serviceDescription") String serviceDescription) {
        UserInfo user = userService.getDataByUserName(authentication.getName());
        Service service = new Service(serviceId, serviceName, serviceType, servicePrice, serviceDescription);
        model.addAttribute("service", service);
        model.addAttribute("user", user);
        return new ModelAndView( "/view/component/buyForm" );
    }

    @RequestMapping(value = "/addRequest", method = RequestMethod.POST)
    @ResponseBody
    public ModelAndView addRequest(ModelMap model, Authentication authentication, @RequestParam("serviceId") Integer serviceId) {
        UserInfo user = userService.getDataByUserName(authentication.getName());
        Request request = new Request(user.getUserId(), serviceId, PENDING);
        requestService.addRequest(request);
        model.addAttribute("successMessage", SUCCESS_MESSAGE);
        return new ModelAndView( "/view/component/successBuy" );
    }
}
