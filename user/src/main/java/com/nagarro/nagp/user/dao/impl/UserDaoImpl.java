package com.nagarro.nagp.user.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.nagarro.nagp.user.dao.UserDao;
import com.nagarro.nagp.user.entity.User;

public class UserDaoImpl implements UserDao {
	
	private static final Logger LOG = LoggerFactory.getLogger(UserDaoImpl.class);
	
	private static List<User> users = new ArrayList<User>();

	@Override
	public List<User> getAllUsers() {
		LOG.info("Mocking the DB call. Fetching data from the list");
		return users;
	}

	@Override
	public void addUser(User user) {
		LOG.info("Mocking the DB call. Adding data to the list");
		List<User> result = users.stream()
				.filter(c -> c.getUsername().equalsIgnoreCase(user.getUsername()))
				.collect(Collectors.toList());
		if(result.isEmpty()) {
			users.add(user);
		}
		else {

			LOG.error("Username already exists in the database.");
		}
		
	}

	@Override
	public User getUserByUsername(String username) {
		LOG.info("Mocking the DB call. Getting user from the list based on username");
		List<User> result = users.stream()
			.filter(c -> c.getUsername().equalsIgnoreCase(username))
			.collect(Collectors.toList());
		return result.get(0);
	}

	@Override
	public boolean updateUser(User user) {
		LOG.info("Mocking the DB call. Updating user in the list.");
		List<User> result = users.stream()
				.filter(c -> c.getUsername().equalsIgnoreCase(user.getUsername()))
				.collect(Collectors.toList());
		if(result.isEmpty()) {
			LOG.error("There is no such user with username " + user.getUsername());
			return Boolean.FALSE;
		}
		return Boolean.TRUE;
	}

}
