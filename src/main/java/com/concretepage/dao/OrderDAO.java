package com.concretepage.dao;

import com.concretepage.dto.OrderDTO;
import com.concretepage.entity.Order;
import com.concretepage.service.IUserService;
import com.concretepage.service.ServiceDAOService;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Transactional
public class OrderDAO {
    @Autowired
    private HibernateTemplate hibernateTemplate;
    @Autowired
    private IUserService userService;
    @Autowired
    private ServiceDAOService serviceDAOService;

    public List<OrderDTO> getAllOrders() {
        List<OrderDTO> orderDTOList = new ArrayList<>();
        Session session = (Session)hibernateTemplate.getSessionFactory().getCurrentSession();
        List results  = session.createQuery("SELECT u.userName, s.name, s.type, s.price, o.date, m.fullName \n" +
                                                "FROM Order o, UserInfo u, Service s, UserInfo m \n" +
                                                "WHERE u.userId = o.customerId \n" +
                                                "AND s.serviceId = o.serviceId \n" +
                                                "AND o.managerId = m.userId").getResultList();

        Iterator iterator = results.iterator();
        while (iterator.hasNext()) {
            OrderDTO orderDTO = new OrderDTO();
            Object[] row = (Object[])iterator.next();
            orderDTO.setCustomerLogin((String) row[0]);
            orderDTO.setServiceName((String) row[1]);
            orderDTO.setServiceType((String) row[2]);
            orderDTO.setServicePrice((double) row[3]);
            orderDTO.setDate((String) row[4]);
            orderDTO.setManagerName((String) row[5]);
            orderDTOList.add(orderDTO);
        }

        return orderDTOList;
    }

    public void addOrder(String customerLogin, String serviceName, Integer managerId, String date) {
        Order order = new Order();
        order.setCustomerId(userService.getDataByUserName(customerLogin).getUserId());
        order.setServiceId(serviceDAOService.getServiceIdByName(serviceName));
        order.setManagerId(managerId);
        order.setDate(date);
        hibernateTemplate.save(order);
    }
}
