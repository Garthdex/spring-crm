package com.concretepage.service;

import com.concretepage.dao.RequestDAO;
import com.concretepage.dto.RequestDTO;
import com.concretepage.entity.Request;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class RequestService {
    @Autowired
    private RequestDAO requestDAO;

    public void addRequest(Request request) {
        requestDAO.addRequest(request);
    }

    public void updateStatusRequest(Integer requestId, String status) {
        requestDAO.updateStatusRequest(requestId, status);
    }

    public Request getRequestById(Integer id) {
        return requestDAO.getRequestById(id);
    }

    public List<RequestDTO> getRequestsDTOForAdmin() {
        return requestDAO.getRequestsDTOForAdmin();
    }

    public List<RequestDTO> getRequestsDTOForUser(Integer userId) {
        return requestDAO.getRequestsDTOForUser(userId);
    }
}
