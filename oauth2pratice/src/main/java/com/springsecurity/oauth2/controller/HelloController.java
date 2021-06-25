package com.springsecurity.oauth2.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@RequestMapping("/hello")
public class HelloController {

	@PreAuthorize("hasAuthority('user')")
	@GetMapping("/hello/user")
	public String userHello() {
		return "Hello User";
	}
	
	@PreAuthorize("hasAuthority('admin')")
	@GetMapping("/hello/admin")
	public String adminHello() {
		return "Hello Admin";
	}
	
	@PreAuthorize("hasAuthority('super admin')")
	@GetMapping("/hello/superadmin")
	public String superAdminHello() {
		return "Hello super admin";
	}
}
