package com.concretepage.entity;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name="users")
public class UserInfo implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="user_id", unique=true, nullable=false)
	private Integer userId;
	@Column(name="username")
	private String userName;
	@Column(name="password")
	private String password;
	@Column(name="role")	
	private String role;
	@Column(name="full_name")	
	private String fullName;
	@Column(name="address")
	private String address;
	@Column(name="phone_number")
	private String phoneNumber;
	@Column(name="enabled")	
	private short enabled;

	public UserInfo() {
	}
	public UserInfo(String userName, String password) {
		this.userName = userName;
		this.password = password;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public short getEnabled() {
		return enabled;
	}
	public void setEnabled(short enabled) {
		this.enabled = enabled;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
}
