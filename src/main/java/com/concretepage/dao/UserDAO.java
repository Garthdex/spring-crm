package com.concretepage.dao;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.transaction.annotation.Transactional;

import com.concretepage.entity.UserInfo;
@Transactional
public class UserDAO {
	@Autowired
	private HibernateTemplate hibernateTemplate;

	public UserInfo getActiveUser(String userName) {
		UserInfo activeUserInfo = new UserInfo();
		short enabled = 1;
		List<?> list = hibernateTemplate.find("FROM UserInfo WHERE userName=? and enabled=?",
				userName, enabled);
		if(!list.isEmpty()) {
			activeUserInfo = (UserInfo)list.get(0);
		}
		return activeUserInfo;
	}

	public void addUser(UserInfo user) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		user.setPassword(encoder.encode(user.getPassword()));
		user.setRole("ROLE_USER");
		user.setEnabled((short) 1);
		hibernateTemplate.save(user);
	}

	public void updateUser(Integer id, String name, String address, String phoneNumber) {
		UserInfo user =  new UserInfo();
		List<?> list = hibernateTemplate.find("FROM UserInfo WHERE id=?" , id);
		if(!list.isEmpty()) {
			user = (UserInfo)list.get(0);
		}
		user.setFullName(name);
		user.setAddress(address);
		user.setPhoneNumber(phoneNumber);
		hibernateTemplate.saveOrUpdate(user);
	}

	public String getUserLoginByUserId(Integer userId) {
		UserInfo user =  new UserInfo();
		List<?> list = hibernateTemplate.find("FROM UserInfo WHERE id=?" , userId);
		if(!list.isEmpty()) {
			user = (UserInfo)list.get(0);
		}
		return user.getUserName();
	}

	public List<UserInfo> getAllCustomers() {
		List<?> list = hibernateTemplate.find("FROM UserInfo WHERE role = 'ROLE_USER'");
		return (List<UserInfo>)list;
	}

	public List<UserInfo> getCustomersByLogin(String login) {
		List<?> list = hibernateTemplate.findByNamedParam("FROM UserInfo " +
														"WHERE role = 'ROLE_USER'" +
														"AND userName LIKE :login", "login", '%'+login+'%');
		return (List<UserInfo>)list;
	}
}