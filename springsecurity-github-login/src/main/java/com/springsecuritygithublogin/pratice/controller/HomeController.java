package com.springsecuritygithublogin.pratice.controller;

//import java.util.Collections;
//import java.util.Map;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
	
	@RequestMapping("/user")
	public String user(@AuthenticationPrincipal OAuth2User principal)
	{
		//return Collections.singletonMap("name", principal.getAttribute("name"));
		return "Hello " + principal.getAttribute("name");
	}
	
	@RequestMapping("/")
	public String hello()
	{
		return "hello world";
	}
}
