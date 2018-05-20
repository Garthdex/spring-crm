package com.concretepage.service;

import com.concretepage.entity.UserInfo;

import java.util.List;

public interface IUserService {
//	@Secured ({"ROLE_ADMIN"})
	UserInfo getDataByUserName(String userName);

	void addUser(UserInfo user);

	void updateUser(Integer id, String name, String address, String phoneNumber);

	List<UserInfo> getAllCustomers();

	List<UserInfo> getCustomersByLogin(String login);
}
 