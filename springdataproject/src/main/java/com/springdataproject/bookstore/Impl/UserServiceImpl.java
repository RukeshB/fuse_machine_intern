package com.springdataproject.bookstore.Impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.springdataproject.bookstore.dto.RoleDto;
import com.springdataproject.bookstore.dto.UserDto;
import com.springdataproject.bookstore.model.Role;
import com.springdataproject.bookstore.model.User;
import com.springdataproject.bookstore.repository.UserRepository;
import com.springdataproject.bookstore.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository repo;
	
	public List<User> pagination(int pageNo, int limit, String sortBy,String firstName,String lastName) {
		Page<User> userData;
		Sort sort = Sort.by(sortBy);
		Pageable Page = PageRequest.of(pageNo, limit, sort);
		if(firstName != null && lastName == null)
		{
			userData = repo.findByFirstName(firstName, Page);
		}
		else if(firstName == null && lastName != null)
		{
			userData = repo.findByLastName(lastName, Page);
		}
		else if(firstName !=null && lastName != null)
		{
			userData = repo.filterByFirstAndLastName(firstName, lastName, Page);
		}
		else
		{
			userData = repo.findAll(Page);
		}
		
		return userData.getContent();
	}
	
	@Override
	public List<UserDto> getUserList(int pageNo, int limit, String sortBy,String firstName,String lastName) {
		List<User> userList = pagination(pageNo, limit, sortBy,firstName,lastName);
		List<UserDto> userDtoList = new ArrayList<>();
		
		for(User user:userList)
		{
			List<RoleDto> roleDtoList = new ArrayList<>();
			for(Role role:user.getRolesid())
			{
				roleDtoList.add(RoleDto.builder().id(role.getId())
												.role(role.getRole())
												.build()
								);
			}
			UserDto userDto = UserDto.builder().id(user.getId())
												.firstName(user.getFirstName())
												.lastName(user.getLastName())
												.email(user.getEmail())
												.phone(user.getPhone())
												.rolesid(roleDtoList)
												.build();
			userDtoList.add(userDto);
		}
		return userDtoList;
	}

	@Override
	public UserDto getUserByID(String id) {
		User user = repo.findById(id).get();
		List<RoleDto> roleDtoList = new ArrayList<>();
		
			for(Role role:user.getRolesid())
			{
				roleDtoList.add(RoleDto.builder().id(role.getId())
												.role(role.getRole())
												.build()
								);
			}
			UserDto userDto = UserDto.builder().id(user.getId())
												.firstName(user.getFirstName())
												.lastName(user.getLastName())
												.email(user.getEmail())
												.phone(user.getPhone())
												.rolesid(roleDtoList)
												.build();
		
		return userDto;
	}

	@Override
	public UserDto addUser(UserDto user) {
		List<Role> roleList = new ArrayList<>();
		for(RoleDto roleDto:user.getRolesid())
		{
			roleList.add(Role.builder().id(roleDto.getId()).build());
		}
		
		User userModel = User.builder().firstName(user.getFirstName())
										.lastName(user.getLastName())
										.email(user.getEmail())
										.phone(user.getPhone())
										.rolesid(roleList)
										.build();
		repo.insert(userModel);
		return user;
	}

	@Override
	public UserDto updateUser(String id, UserDto user) {
		if(repo.findById(id).get() != null)
		{
			List<Role> roleList = new ArrayList<>();
			for(RoleDto roleDto:user.getRolesid())
			{
				roleList.add(Role.builder().id(roleDto.getId()).build());
			}
			
			User userModel = User.builder().id(id)
											.firstName(user.getFirstName())
											.lastName(user.getLastName())
											.email(user.getEmail())
											.phone(user.getPhone())
											.rolesid(roleList)
											.build();
			repo.save(userModel);
		}
		return user;
	}

	@Override
	public String deleteUser(String id) {
		repo.deleteById(id);
		return "delete user with id "+id;
	}

}
