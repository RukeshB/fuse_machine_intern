package com.jwtauth2.pratice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jwtauth2.pratice.dto.JwtRequest;
import com.jwtauth2.pratice.dto.JwtResponse;
import com.jwtauth2.pratice.dto.UserDto;
import com.jwtauth2.pratice.impl.JwtUserDetailsService;
import com.jwtauth2.pratice.util.JwtTokenUtil;

@RestController
@CrossOrigin
public class JwtUsersAuthenticationController {

	@Autowired
	AuthenticationManager authenticationManager;
	
	@Autowired
	JwtUserDetailsService userDetailService;
	
	@Autowired
	JwtTokenUtil jwtToken;
	
	@RequestMapping(value = "/authenticate",method =  RequestMethod.POST)
	public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authRequest) throws Exception
	{
		try {
			authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(
							authRequest.getUserName(), 
							authRequest.getPassword()
							)
					);
		}
		catch(BadCredentialsException ex)
		{
			throw new Exception("WRONG_CREDENTIALS", ex);
		}
		
		final UserDetails USER = userDetailService.loadUserByUsername(authRequest.getUserName());
		final String token = jwtToken.generateToken(USER);
		
		return ResponseEntity.ok(new JwtResponse(token));
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ResponseEntity<?> registerUser(@RequestBody UserDto user)
	{
		return ResponseEntity.ok(userDetailService.addUser(user));
	}
}
