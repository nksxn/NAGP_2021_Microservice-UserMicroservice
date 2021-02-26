package com.nagarro.nagp.user.service.impl;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagarro.nagp.user.dao.UserDao;
import com.nagarro.nagp.user.entity.User;
import com.nagarro.nagp.user.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserDao userDao;
	
	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
	
	@Override
	public List<User> getAllUsers() {
		return userDao.getAllUsers();
		
	}

	@Override
	public void addUser(User user) {
		LocalDateTime now = LocalDateTime.now();  
		user.setCreationTime(dtf.format(now));
		user.setModifiedTime(dtf.format(now));
		userDao.addUser(user);
	}

	@Override
	public User getUserByUsername(String username) {
		return userDao.getUserByUsername(username);
	}

	@Override
	public boolean updateUser(User user) {
		LocalDateTime now = LocalDateTime.now();
		user.setModifiedTime(dtf.format(now));
		return userDao.updateUser(user);
	}

}
