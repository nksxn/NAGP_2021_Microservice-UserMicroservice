package com.nagarro.nagp.user.service;

import java.util.List;

import com.nagarro.nagp.user.entity.User;

public interface UserService {
	
	public List<User> getAllUsers();

	public void addUser(User user);

	public User getUserByUsername(String username);

	public boolean updateUser(User user);

}
