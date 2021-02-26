package com.nagarro.nagp.user.dao.impl;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.nagarro.nagp.user.dao.UserDao;
import com.nagarro.nagp.user.entity.User;

@Repository
public class UserDaoImpl implements UserDao {

	private static final Logger LOG = LoggerFactory.getLogger(UserDaoImpl.class);

	private static List<User> users = new ArrayList<User>();
	
	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");

	@PostConstruct
	public void init() {
		LOG.info("Creting Dummy data for Users.");
		LocalDateTime now = LocalDateTime.now();
		User user1 = new User();
		user1.setUid("1");
		user1.setFirstName("Kanak");
		user1.setLastName("Dhaka");
		user1.setEmail("kanak.dhaka@gmail.com");
		user1.setPhone("9853472311");
		user1.setUsername("kanakDhaka");
		user1.setPassword("qwerty@123");
		user1.setCreationTime(dtf.format(now));
		user1.setModifiedTime(dtf.format(now));
		User user2 = new User();
		user2.setUid("2");
		user2.setFirstName("Nimish");
		user2.setLastName("Saxena");
		user2.setEmail("vibhu.saxena31@gmail.com");
		user2.setPhone("9873640321");
		user2.setUsername("nksxn");
		user2.setPassword("qwerty@123");
		user2.setCreationTime(dtf.format(now));
		user2.setModifiedTime(dtf.format(now));
		users.add(user1);
		users.add(user2);
	}

	@Override
	public List<User> getAllUsers() {
		LOG.info("Mocking the DB call. Fetching data from the list");
		return users;
	}

	@Override
	public void addUser(User user) {
		LOG.info("Mocking the DB call. Adding data to the list");
		List<User> result = users.stream().filter(c -> c.getUsername().equalsIgnoreCase(user.getUsername()))
				.collect(Collectors.toList());
		if (result.isEmpty()) {
			users.add(user);
		} else {

			LOG.error("Username already exists in the database.");
		}

	}

	@Override
	public User getUserByUsername(String username) {
		LOG.info("Mocking the DB call. Getting user from the list based on username");
		List<User> result = users.stream().filter(c -> c.getUsername().equalsIgnoreCase(username))
				.collect(Collectors.toList());
		return result.get(0);
	}

	@Override
	public boolean updateUser(User user) {
		LOG.info("Mocking the DB call. Updating user in the list.");
		List<User> result = users.stream().filter(c -> c.getUsername().equalsIgnoreCase(user.getUsername()))
				.collect(Collectors.toList());
		if (result.isEmpty()) {
			LOG.error("There is no such user with username " + user.getUsername());
			return Boolean.FALSE;
		}
		return Boolean.TRUE;
	}

}
