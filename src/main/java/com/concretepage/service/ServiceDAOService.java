package com.concretepage.service;

import com.concretepage.dao.ServiceDAO;
import com.concretepage.entity.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ServiceDAOService {
    @Autowired
    ServiceDAO serviceDAO;
    public List<Service> getServicesByType(String type) {
        return serviceDAO.getServicesByType(type);
    }
}
