package com.concretepage.dto;

public class OrderDTO {
    private String customerLogin;
    private String serviceName;
    private String serviceType;
    private double servicePrice;
    private String managerName;
    private String date;

    public OrderDTO() {
    }
    public OrderDTO(String customerLogin, String serviceName, String serviceType, double servicePrice, String managerName, String date) {
        this.customerLogin = customerLogin;
        this.serviceName = serviceName;
        this.serviceType = serviceType;
        this.servicePrice = servicePrice;
        this.managerName = managerName;
        this.date = date;
    }

    public String getCustomerLogin() {
        return customerLogin;
    }
    public void setCustomerLogin(String customerLogin) {
        this.customerLogin = customerLogin;
    }
    public String getServiceName() {
        return serviceName;
    }
    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }
    public String getServiceType() {
        return serviceType;
    }
    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }
    public double getServicePrice() {
        return servicePrice;
    }
    public void setServicePrice(double servicePrice) {
        this.servicePrice = servicePrice;
    }
    public String getManagerName() {
        return managerName;
    }
    public void setManagerName(String managerName) {
        this.managerName = managerName;
    }
    public String getDate() {
        return date;
    }
    public void setDate(String date) {
        this.date = date;
    }
}
