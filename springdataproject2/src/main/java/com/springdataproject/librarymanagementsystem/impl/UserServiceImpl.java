package com.springdataproject.librarymanagementsystem.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springdataproject.librarymanagementsystem.dto.RoleDto;
import com.springdataproject.librarymanagementsystem.dto.UserDto;
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
		List<RoleDto> roleDtoList ;
		
		for(User user:userList)
		{
			roleDtoList = new ArrayList<>();
			for(String roleid:user.getRoleID())
			{
				RoleDto roleDto = roleService.getroleByID(roleid);
				roleDtoList.add(roleDto);
			}
			UserDto userDto = UserDto.builder().id(user.getId())
											.firstName(user.getFirstName())
											.lastName(user.getLastName())
											.email(user.getEmail())
											.contact(user.getContact())
											.roles(roleDtoList)
											.build();
			userDtoList.add(userDto);
		}
		return userDtoList;
	}

	@Override
	public UserDto getuserByID(String id) {
		User user = userRepo.findById(id)
				.orElseThrow(()->new IllegalStateException("User data not Found"));
		List<RoleDto> roleDtoList = new ArrayList<>();
		
			for(String roleid:user.getRoleID())
			{
				RoleDto roleDto = roleService.getroleByID(roleid);
				roleDtoList.add(roleDto);
			}
			UserDto userDto = UserDto.builder().id(user.getId())
											.firstName(user.getFirstName())
											.lastName(user.getLastName())
											.email(user.getEmail())
											.contact(user.getContact())
											.roles(roleDtoList)
											.build();
		return userDto;
	}

	@Override
	public UserDto adduser(UserDto user) {
		List<String> roleIdList = new ArrayList<>();
		for(String roleID:user.getRoleID())
		{
			//String roleId = roleDto.getId();
			roleIdList.add(roleID);
		}
		User userModel = User.builder().firstName(user.getFirstName())
										.lastName(user.getLastName())
										.email(user.getEmail())
										.contact(user.getContact())
										.roleID(roleIdList)
										.build();
		
		userRepo.insert(userModel);
		return user;
	}

	@Override
	public UserDto updateuser(String id, UserDto user) {
		User userModel = userRepo.findById(id)
				.orElseThrow(()->new IllegalStateException("User data not Found"));
		List<String> roleIdList = new ArrayList<>();
		for(String roleID:user.getRoleID())
		{
//			String roleId = roleDto.getId();
			roleIdList.add(roleID);
		}
		userModel = User.builder().id(id)
										.firstName(user.getFirstName())
										.lastName(user.getLastName())
										.email(user.getEmail())
										.contact(user.getContact())
										.roleID(roleIdList)
										.build();
		
		userRepo.save(userModel);
		return user;
	}

	@Override
	public String deleteuser(String id) {
		userRepo.deleteById(id);
		return "User with id: "+id+" deleted";
	}
}
