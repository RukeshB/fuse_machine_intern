package com.jwtauth.pratice.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
	
	@RequestMapping("/")
	public String sayHello()
	{
		return "Hello World";
	}
	
	@RequestMapping("/admin")
	public String adminHello()
	{
		return "Hello Admin";
	}
	
	@RequestMapping("/superadmin")
	public String superAdminHello()
	{
		return "Hello Super Admin";
	}
}
