package com.nagarro.nagp.user.facade;

import java.util.List;

import org.springframework.stereotype.Component;

import com.nagarro.nagp.user.entity.User;

@Component
public interface UserFacade {

	public List<User> getAllUsers();

	public void addUser(User user);

	public User getUserByUsername(String username);

	public boolean updateUser(User user);

	public void notifyUser(String username);

}
