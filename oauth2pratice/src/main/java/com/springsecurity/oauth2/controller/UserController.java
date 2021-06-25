package com.springsecurity.oauth2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springsecurity.oauth2.dto.UserDto;
import com.springsecurity.oauth2.model.User;
import com.springsecurity.oauth2.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	UserService userService;
	
	@PostMapping()
	public User saveUser(@RequestBody UserDto userdto)
	{
		return userService.addUser(userdto);
	}
	
	@GetMapping()
	public String user()
	{
		return "Hello world";
	}
}
