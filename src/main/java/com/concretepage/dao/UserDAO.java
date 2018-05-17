package com.concretepage.dao;
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
		user.setFullName("sd");
		user.setRole("ROLE_USER");
		user.setCountry("USSR");
		user.setEnabled((short) 1);
		hibernateTemplate.save(user);
	}
}