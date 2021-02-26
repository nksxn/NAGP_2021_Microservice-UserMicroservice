package com.nagarro.nagp.user.facade;

import java.util.Map;

import org.springframework.stereotype.Component;

import com.nagarro.nagp.user.entity.User;

@Component
public interface UserFacade {
	
	public Map<String, Object> getAllUsers();

	public void addUser(User user);

	public Map<String, Object> getUserByUsername(String username);

	public boolean updateUser(User user);

}
