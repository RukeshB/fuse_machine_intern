package com.springdataproject.bookstore.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springdataproject.bookstore.dto.UserDto;
import com.springdataproject.bookstore.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	private UserService service;
	
	@GetMapping("/")
	public List<UserDto> getUserList(
			@RequestParam(name = "pageNo", defaultValue = "0") int pageNo,
			@RequestParam(name = "limit", defaultValue = "2") int limit,
			@RequestParam(name = "sortBy", defaultValue = "id") String sortBy,
			@RequestParam(name = "firstName", required = false) String firstName,
			@RequestParam(name = "lastName", required = false) String lastName
			)
	{
		return service.getUserList(pageNo, limit, sortBy,firstName,lastName);
	}
	
	@GetMapping("/{id}")
	public UserDto getUserByID(@PathVariable String id)
	{
		return service.getUserByID(id);
	}
	
	@PostMapping("/")
	public UserDto addUser(@Valid @RequestBody UserDto user)
	{
		return service.addUser(user);
	}
	
	@PutMapping("/{id}")
	public UserDto UpdateUser(@Valid @RequestBody UserDto user,@PathVariable String id)
	{
		return service.updateUser(id, user);
	}
	
	@DeleteMapping("/{id}")
	public String deleteUser(@PathVariable String id)
	{
		return service.deleteUser(id);
	}
}
