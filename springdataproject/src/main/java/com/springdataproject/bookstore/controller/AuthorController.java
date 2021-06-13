package com.springdataproject.bookstore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springdataproject.bookstore.dto.AuthorDto;
import com.springdataproject.bookstore.service.AuthorService;

@RestController
@RequestMapping("/authors")
public class AuthorController {

	@Autowired
	AuthorService service;
	
	@GetMapping("/")
	public List<AuthorDto> getAuthorList()
	{
		return service.getAuthorList();
	}
	
	@GetMapping("/{id}")
	public AuthorDto getAuthorByID(@PathVariable String id)
	{
		return service.getAuthorByID(id);
	}
	
	@PostMapping("/")
	public AuthorDto addAuthor(@PathVariable String id,@RequestBody AuthorDto author)
	{
		return service.addAuthor(author);
	}
	
	@PostMapping("/{id}")
	public AuthorDto updateAuthor(@PathVariable String id,@RequestBody AuthorDto author)
	{
		return service.updateAuthor(id, author);
	}
	
	@GetMapping("/{id}")
	public String deleteAuthor(@PathVariable String id)
	{
		return service.deleteAuthor(id);
	}
}
