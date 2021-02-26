package com.nagarro.nagp.user.facade;

import java.util.Map;

import com.nagarro.nagp.user.entity.User;

public interface UserFacade {
	
	public Map<String, Object> getAllUsers();

	public void addUser(User user);

	public Map<String, Object> getUserByUsername(String username);

	public boolean updateUser(User user);

}
