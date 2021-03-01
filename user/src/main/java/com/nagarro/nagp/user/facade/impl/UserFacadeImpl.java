package com.nagarro.nagp.user.facade.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.nagarro.nagp.user.entity.User;
import com.nagarro.nagp.user.facade.UserFacade;
import com.nagarro.nagp.user.service.UserService;

@Component
public class UserFacadeImpl implements UserFacade {

	@Autowired
	UserService userService;

	@Override
	public List<User> getAllUsers() {

		List<User> result = userService.getAllUsers();
		return result;

	}

	@Override
	public void addUser(User user) {
		userService.addUser(user);
	}

	@Override
	public User getUserByUsername(String username) {
		User user = userService.getUserByUsername(username);
		return user;
	}

	@Override
	public boolean updateUser(User user) {
		return userService.updateUser(user);
	}

	@Override
	public void notifyUser(String username) {
		userService.notifyUser(username);
	}

}
