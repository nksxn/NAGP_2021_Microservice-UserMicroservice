package com.nagarro.nagp.user.facade.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	public Map<String, Object> getAllUsers() {
		
		List<User> result = userService.getAllUsers();
		Map<String, Object> responseData = new HashMap<String, Object>();
		responseData.put("users", result);
		return responseData;
	
	}

	@Override
	public void addUser(User user) {
		userService.addUser(user);		
	}

	@Override
	public Map<String, Object> getUserByUsername(String username) {
		User user = userService.getUserByUsername(username);
		Map<String, Object> responseData = new HashMap<String, Object>();
		responseData.put("user", user);
		return responseData;
	}

	@Override
	public boolean updateUser(User user) {
		return userService.updateUser(user);		
	}

}
