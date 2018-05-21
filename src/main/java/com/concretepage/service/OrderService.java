package com.concretepage.service;

import com.concretepage.dao.OrderDAO;
import com.concretepage.dto.OrderDTO;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class OrderService {
    @Autowired
    private OrderDAO orderDAO;

    public List<OrderDTO> getAllOrders() {
        return orderDAO.getAllOrders();
    }

    public void addOrder(String customerLogin, String serviceName, Integer managerId, String date) {
        orderDAO.addOrder(customerLogin, serviceName, managerId, date);
    }
}
