package com.concretepage.controller;

import com.concretepage.service.ServiceDAOService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class ServiceController {
    @Autowired
    private ServiceDAOService service;
}
