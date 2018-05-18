package com.concretepage.service;

import org.springframework.security.access.annotation.Secured;

import com.concretepage.entity.UserInfo;

public interface IUserService {
//	@Secured ({"ROLE_ADMIN"})
	UserInfo getDataByUserName(String userName);

	void addUser(UserInfo user);

	void updateUser(Integer id, String name, String address, String phoneNumber);
}
 