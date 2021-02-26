package com.nagarro.nagp.user.controller;


import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.nagp.user.entity.User;
import com.nagarro.nagp.user.facade.UserFacade;

@RestController
@RequestMapping(value = "/users")
public class UserController {
	
	@Value("${server.port}")
	private int port;
	
	@Autowired
	UserFacade userFacade;
	
	@GetMapping
	public ResponseEntity<Map<String, Object>> getAllUsers() {
		
		Map<String, Object> responseData = userFacade.getAllUsers();

		return new ResponseEntity<Map<String, Object>>(responseData, new HttpHeaders(), HttpStatus.OK);
	}
	
	
	@PostMapping()
	public ResponseEntity<Void> addUser(@RequestBody User user) {
		try{
			userFacade.addUser(user);
			HttpHeaders headers = new HttpHeaders();
			return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
		}catch (Exception e) {
			return new ResponseEntity<Void>(new HttpHeaders(), HttpStatus.SERVICE_UNAVAILABLE);
		}
	}
	
	@GetMapping("/{username}")
	public ResponseEntity<Map<String, Object>> getUserByUsername(@PathVariable("username") String username) {
		Map<String, Object> responseData = userFacade.getUserByUsername(username);
		return new ResponseEntity<Map<String, Object>>(responseData, new HttpHeaders(), HttpStatus.OK);
	}
	
	@PutMapping()
	public ResponseEntity<Void> editUser(@RequestBody User user) {
		HttpHeaders headers = new HttpHeaders();
		if(userFacade.updateUser(user)) {
			return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
		}
		return new ResponseEntity<Void>(headers, HttpStatus.BAD_REQUEST);
	}


}
