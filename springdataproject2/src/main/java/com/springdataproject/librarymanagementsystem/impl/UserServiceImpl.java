package com.springdataproject.librarymanagementsystem.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springdataproject.librarymanagementsystem.dto.UserDto;
import com.springdataproject.librarymanagementsystem.model.Role;
import com.springdataproject.librarymanagementsystem.model.User;
import com.springdataproject.librarymanagementsystem.repository.UserRepository;
import com.springdataproject.librarymanagementsystem.service.RoleService;
import com.springdataproject.librarymanagementsystem.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepo;

	@Autowired
	private RoleService roleService;
	
	@Override
	public List<UserDto> getuserList(String firstName, String lastName, int pageno, int limit, String sortBy) {
		List<User> userList = userRepo.findAll();
		List<UserDto> userDtoList = new ArrayList<>();
		List<Role> roleList ;
		
		for(User user:userList)
		{
			roleList = new ArrayList<>();
			for(String role:user.getRoleID())
			{
				
			}
		}
		return null;
	}

	@Override
	public UserDto getuserByID(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserDto adduser(UserDto user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserDto updateuser(String id, UserDto user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteuser(String id) {
		// TODO Auto-generated method stub
		return null;
	}
}
