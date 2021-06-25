package com.springsecurity.oauth2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.springsecurity.oauth2.dto.UserDto;
import com.springsecurity.oauth2.model.User;
import com.springsecurity.oauth2.repository.UserRepository;

@Service
public class UserService{
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	public User findByUserName(String userName)
	{
		return userRepo.findByUserName(userName);
	}
	
	public User addUser(UserDto userdto)
	{
		User user = User.builder().userName(userdto.getUserName())
									.email(userdto.getEmail())
									.roles(userdto.getRoles())
									.password(passwordEncoder.encode(userdto.getPassword()))
									.build();
		userRepo.insert(user);
		return user;
	}
}
