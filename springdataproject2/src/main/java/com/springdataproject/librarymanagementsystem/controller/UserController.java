package com.springdataproject.librarymanagementsystem.controller;

import java.util.List;

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

import com.springdataproject.librarymanagementsystem.dto.UserDto;
import com.springdataproject.librarymanagementsystem.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
	@Autowired
	UserService service;
	
	@GetMapping
	public List<UserDto> getuserList(
			@RequestParam(required = false) String firstName,
			@RequestParam(required = false) String lastName,
			@RequestParam(defaultValue = "0") int pageNo,
			@RequestParam(defaultValue = "2") int limit,
			@RequestParam(defaultValue = "id") String sortBy
					)
	{
		return service.getuserList(firstName,lastName,pageNo,limit,sortBy);
	}
	
	@GetMapping("/{id}")
	public UserDto getuserByID(@PathVariable String id) throws Exception
	{
		return service.getuserByID(id);
	}
	
	@PostMapping
	public UserDto adduser(@RequestBody UserDto user)
	{
		return service.adduser(user);
	}
	
	@PutMapping("/{id}")
	public UserDto updateuser(@PathVariable String id,@RequestBody UserDto user) throws Exception
	{
		return service.updateuser(id, user);
	}
	
	@DeleteMapping("/{id}")
	public String deleteuser(@PathVariable String id)
	{
		return service.deleteuser(id);
	}
}
