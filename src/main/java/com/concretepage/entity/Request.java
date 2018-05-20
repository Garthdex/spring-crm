package com.concretepage.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "requests")
public class Request implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="request_id", unique=true, nullable=false)
    private Integer requestId;
    @Column(name="user_id")
    private Integer userId;
    @Column(name="service_id")
    private Integer serviceId;
    @Column(name="status")
    private String status;

    public Request() {
    }
    public Request(Integer userId, Integer serviceId, String status) {
        this.userId = userId;
        this.serviceId = serviceId;
        this.status = status;
    }
    public Integer getRequestId() {
        return requestId;
    }
    public void setRequestId(Integer requestId) {
        this.requestId = requestId;
    }
    public Integer getUserId() {
        return userId;
    }
    public void setUserId(Integer userId) {
        this.userId = userId;
    }
    public Integer getServiceId() {
        return serviceId;
    }
    public void setServiceId(Integer serviceId) {
        this.serviceId = serviceId;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
}
