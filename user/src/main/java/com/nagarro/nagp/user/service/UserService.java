package com.nagarro.nagp.user.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.nagarro.nagp.user.entity.User;

@Service
public interface UserService {
	
	public List<User> getAllUsers();

	public void addUser(User user);

	public User getUserByUsername(String username);

	public boolean updateUser(User user);

	public void notifyUser(String username);

}
