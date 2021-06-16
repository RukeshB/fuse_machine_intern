package com.springdataproject.librarymanagementsystem.service;

import java.util.List;

import com.springdataproject.librarymanagementsystem.dto.UserDto;

public interface UserService {
	public List<UserDto> getuserList(String firstName,String lastName,
			int pageno,int limit,String sortBy);
	public UserDto getuserByID(String id);
	public UserDto adduser(UserDto user);
	public UserDto updateuser(String id,UserDto user);
	public String deleteuser(String id);
}
