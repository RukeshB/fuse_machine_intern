package com.springdataproject.bookstore.service;

import java.util.List;

import com.springdataproject.bookstore.dto.UserDto;

public interface UserService {
	public List<UserDto> getUserList(int pageNo, int limit, String sortBy,String firstName,String lastName);
	public UserDto getUserByID(String id);
	public UserDto addUser(UserDto user);
	public UserDto updateUser(String id,UserDto user);
	public String deleteUser(String id);
}
