package com.springsecurity.oauth2.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.springsecurity.oauth2.model.User;

@Service
public class CustomeuserDetailService implements UserDetailsService{

	@Autowired
	UserService userService;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		List<GrantedAuthority> roles = new ArrayList<>();
		User dbuser = userService.findByUserName(username);
		
		if(dbuser ==  null)
		{
			throw new UsernameNotFoundException("user with User Nmae: "+username+" Not Found");
		}
		
		for(String role:dbuser.getRoles())
		{
			roles.add(new SimpleGrantedAuthority(role));
		}
		
		return new org.springframework.security.core.userdetails.User(
				username,dbuser.getPassword() ,roles);
	}

}
