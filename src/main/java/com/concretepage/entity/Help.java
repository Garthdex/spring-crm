package com.concretepage.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "help")
public class Help implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="help_id", unique=true, nullable=false)
    private Integer helpId;
    @Column(name="phone_number")
    private String phoneNumber;
    @Column(name="message")
    private String message;

    public Help() {
    }
    public Help(String phoneNumber, String message) {
        this.phoneNumber = phoneNumber;
        this.message = message;
    }
    public Integer getHelpId() {
        return helpId;
    }
    public void setHelpId(Integer helpId) {
        this.helpId = helpId;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
}
