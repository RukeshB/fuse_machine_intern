package com.jwtauth2.pratice.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.jwtauth2.pratice.dto.UserDto;
import com.jwtauth2.pratice.model.User;
import com.jwtauth2.pratice.repository.UserRepository;

@Service
public class JwtUserDetailsService implements UserDetailsService{

	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private PasswordEncoder bcryptEncoder;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		User user = userRepo.findByEmail(email);
		if(user == null)
		{
			 throw new UsernameNotFoundException("User not found with email:"+email);
		}
		return new org.springframework.security.core.userdetails.User(user.getEmail(),user.getPassword(),new ArrayList<>());
	}
	
	public User addUser(UserDto user)
	{
		User userModel = User.builder().userName(user.getUserName())
										.roles(user.getRoles())
										.email(user.getEmail())
										.password(bcryptEncoder.encode(user.getPassword()))
										.build();
		userRepo.insert(userModel);
		return userModel;
	}

}
