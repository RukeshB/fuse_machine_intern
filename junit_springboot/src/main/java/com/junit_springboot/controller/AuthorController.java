package com.junit_springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.junit_springboot.model.Author;
import com.junit_springboot.service.AuthorService;

@RestController
public class AuthorController {
	
	@Autowired
	private AuthorService service;
	
	@GetMapping("/hello")
	public String hello()
	{
		return "hello world";
	}
	
	@GetMapping("/authors")
	public List<Author> getAuthorList()
	{
		return service.getAuthorList();
	}
}
