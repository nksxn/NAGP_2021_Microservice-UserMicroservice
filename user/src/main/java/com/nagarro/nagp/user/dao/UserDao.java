package com.nagarro.nagp.user.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.nagarro.nagp.user.entity.User;

@Repository
public interface UserDao {
	
	public List<User> getAllUsers();

	public void addUser(User user);

	public User getUserByUsername(String username);

	public boolean updateUser(User user);

}
