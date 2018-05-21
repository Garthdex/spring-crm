package com.concretepage.entity;

import javax.persistence.*;

@Entity
@Table(name = "orders")
public class Order {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="order_id", unique=true, nullable=false)
    private Integer orderId;
    @Column(name="customer_id")
    private Integer customerId;
    @Column(name="service_id")
    private Integer serviceId;
    @Column(name="manager_id")
    private Integer managerId;
    @Column(name="date")
    private String date;


    public Order() {
    }
    public Order(Integer customerId, Integer serviceId, Integer managerId, String date) {
        this.customerId = customerId;
        this.serviceId = serviceId;
        this.managerId = managerId;
        this.date = date;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }
    public Integer getOrderId() {
        return orderId;
    }
    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }
    public Integer getCustomerId() {
        return customerId;
    }
    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }
    public Integer getServiceId() {
        return serviceId;
    }
    public void setServiceId(Integer serviceId) {
        this.serviceId = serviceId;
    }
    public Integer getManagerId() {
        return managerId;
    }
    public void setManagerId(Integer managerId) {
        this.managerId = managerId;
    }
    public String getDate() {
        return date;
    }
    public void setDate(String date) {
        this.date = date;
    }
}
