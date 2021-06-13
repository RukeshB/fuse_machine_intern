package com.springdataproject.bookstore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springdataproject.bookstore.dto.UserDto;
import com.springdataproject.bookstore.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	private UserService service;
	
	@GetMapping("/")
	public List<UserDto> getUserList()
	{
		return service.getUserList();
	}
	
	@GetMapping("/{id}")
	public UserDto getUserByID(@PathVariable String id)
	{
		return service.getUserByID(id);
	}
	
	@PostMapping("/")
	public UserDto addUser(@RequestBody UserDto user)
	{
		return service.addUser(user);
	}
	
	@PutMapping("/{id}")
	public UserDto UpdateUser(@RequestBody UserDto user,@PathVariable String id)
	{
		return service.updateUser(id, user);
	}
	
	@DeleteMapping("/{id}")
	public String deleteUser(@PathVariable String id)
	{
		return service.deleteUser(id);
	}
}
