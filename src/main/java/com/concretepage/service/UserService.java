package com.concretepage.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.concretepage.dao.UserDAO;
import com.concretepage.entity.UserInfo;
public class UserService implements IUserService {
	@Autowired
	private UserDAO userDAO;
	public UserInfo getDataByUserName(String userName) {
		return userDAO.getActiveUser(userName);
	}

	@Override
	public void addUser(UserInfo user) {
		userDAO.addUser(user);
	}

	@Override
	public void updateUser(Integer id, String name, String address, String phoneNumber) {
		userDAO.updateUser(id, name, address, phoneNumber);
	}

}
