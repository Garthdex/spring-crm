package com.concretepage.controller;

import com.concretepage.dto.OrderDTO;
import com.concretepage.entity.UserInfo;
import com.concretepage.service.IUserService;
import com.concretepage.service.OrderService;
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
public class OrderController {
    @Autowired
    OrderService orderService;
    @Autowired
    private IUserService userService;

    @RequestMapping(value = "/orders")
    @ResponseBody
    public ModelAndView getAllOrders(ModelMap model){
        model.addAttribute("orders", orderService.getAllOrders());
        return new ModelAndView( "/view/component/orders" );
    }

    @RequestMapping(value = "/addOrderForm")
    @ResponseBody
    public ModelAndView getOrderFormTemplate(){
        return new ModelAndView( "/view/component/addOrderForm" );
    }

    @RequestMapping(value = "/addOrder", method = RequestMethod.POST)
    @ResponseBody
    public void addOrder(Authentication authentication,
                         @RequestParam("customerLogin") String customerLogin,
                         @RequestParam("serviceName") String serviceName,
                         @RequestParam("date") String date)    {
        UserInfo manager = userService.getDataByUserName(authentication.getName());
        orderService.addOrder(customerLogin, serviceName, manager.getUserId(), date);
    }
}
