package com.concretepage.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "services")
public class Service implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="service_id", unique=true, nullable=false)
    private Integer serviceId;
    @Column(name="name")
    private String name;
    @Column(name="type")
    private String type;
    @Column(name="price")
    private double price;
    @Column(name = "description")
    private String description;

    public Service() {
    }
    public Service(Integer serviceId, String name, String type, double price, String description) {
        this.name = name;
        this.type = type;
        this.price = price;
        this.description = description;
        this.serviceId = serviceId;
    }
    public Integer getServiceId() {
        return serviceId;
    }
    public void setServiceId(Integer serviceId) {
        this.serviceId = serviceId;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
}
