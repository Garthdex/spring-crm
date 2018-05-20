package com.concretepage.dao;

import com.concretepage.dto.RequestDTO;
import com.concretepage.entity.Request;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Transactional
public class RequestDAO {
    @Autowired
    private HibernateTemplate hibernateTemplate;

    public void addRequest(Request request) {
        hibernateTemplate.save(request);
    }

    public void updateStatusRequest(Integer requestId, String status) {
        Request request = new Request();
        List<?> list = hibernateTemplate.find("FROM Request WHERE id=?" , requestId);
        if(!list.isEmpty()) {
            request = (Request)list.get(0);
        }
        request.setStatus(status);
        hibernateTemplate.saveOrUpdate(request);
    }

    public Request getRequestById(Integer id) {
        Request request = new Request();
        List<?> list = hibernateTemplate.find("FROM Request WHERE id=?" , id);
        if(!list.isEmpty()) {
            request = (Request)list.get(0);
        }
        return request;
    }

    public List<RequestDTO> getRequestsDTOForAdmin() {
        List<RequestDTO> requestDTOList = new ArrayList<>();
        Session session = (Session)hibernateTemplate.getSessionFactory().getCurrentSession();
        List results  = session.createQuery("SELECT u.userName, s.name, s.type, s.price, r.status, r.requestId\n" +
                                                        "FROM Request r, UserInfo u, Service s \n" +
                                                        "WHERE u.userId = r.userId\n" +
                                                        "AND s.serviceId = r.serviceId").getResultList();

        Iterator iterator = results.iterator();
        while (iterator.hasNext()) {
            RequestDTO requestDTO = new RequestDTO();
            Object[] row = (Object[])iterator.next();
            requestDTO.setUserLogin((String) row[0]);
            requestDTO.setServiceName((String) row[1]);
            requestDTO.setServiceType((String) row[2]);
            requestDTO.setServicePrice((double) row[3]);
            requestDTO.setRequestStatus((String) row[4]);
            requestDTO.setRequestId((Integer) row[5]);
            requestDTOList.add(requestDTO);
        }

        return requestDTOList;
    }

    public List<RequestDTO> getRequestsDTOForUser(Integer userId) {
        List<RequestDTO> requestDTOList = new ArrayList<>();
        Session session = (Session)hibernateTemplate.getSessionFactory().getCurrentSession();
        List results  = session.createQuery("SELECT s.name, s.type, s.price, r.status\n" +
                                                "FROM Request r, Service s \n" +
                                                "WHERE ? = r.userId\n" +
                                                "AND s.serviceId = r.serviceId").setString(0, String.valueOf(userId)).getResultList();

        Iterator iterator = results.iterator();
        while (iterator.hasNext()) {
            RequestDTO requestDTO = new RequestDTO();
            Object[] row = (Object[])iterator.next();
            requestDTO.setServiceName((String) row[0]);
            requestDTO.setServiceType((String) row[1]);
            requestDTO.setServicePrice((double) row[2]);
            requestDTO.setRequestStatus((String) row[3]);
            requestDTOList.add(requestDTO);
        }

        return requestDTOList;
    }
}
