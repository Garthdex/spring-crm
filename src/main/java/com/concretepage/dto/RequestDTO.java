package com.concretepage.dto;

public class RequestDTO {
    private String userLogin;
    private String serviceName;
    private String serviceType;
    private double servicePrice;
    private String requestStatus;
    private Integer requestId;

    public RequestDTO() {
    }
    public RequestDTO(String userLogin, String serviceName, String serviceType, double servicePrice, String requestStatus, Integer requestId) {
        this.userLogin = userLogin;
        this.serviceName = serviceName;
        this.serviceType = serviceType;
        this.servicePrice = servicePrice;
        this.requestStatus = requestStatus;
        this.requestId = requestId;
    }
    public String getUserLogin() {
        return userLogin;
    }
    public void setUserLogin(String userLogin) {
        this.userLogin = userLogin;
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
    public String getRequestStatus() {
        return requestStatus;
    }
    public void setRequestStatus(String requestStatus) {
        this.requestStatus = requestStatus;
    }
    public Integer getRequestId() {
        return requestId;
    }
    public void setRequestId(Integer requestId) {
        this.requestId = requestId;
    }
}
