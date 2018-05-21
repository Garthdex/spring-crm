package com.concretepage.dao;

import com.concretepage.entity.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public class ServiceDAO {
    @Autowired
    private HibernateTemplate hibernateTemplate;

    public List<Service> getServicesByType(String type) {
        List<?> list = hibernateTemplate.find("FROM Service WHERE type=?" , type);
        return (List<Service>) list;
    }

    public Integer getServiceIdByName(String name) {
        Service service = new Service();
        List<?> list = hibernateTemplate.find("FROM Service WHERE name=?" , name);
        if(!list.isEmpty()) {
            service = (Service)list.get(0);
        }
        return service.getServiceId();
    }
}
