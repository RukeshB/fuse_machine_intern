package com.springdataproject.librarymanagementsystem.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springdataproject.librarymanagementsystem.dto.AuthorDto;
import com.springdataproject.librarymanagementsystem.service.AuthorService;

@RestController
@RequestMapping("/authors")
public class AuthorController {
	
	@Autowired
	AuthorService service;
	
	@GetMapping
	public List<AuthorDto> getAuthorList(
			@RequestParam(required = false) String firstName,
			@RequestParam(required = false) String lastName,
			@RequestParam(defaultValue = "0") int pageNo,
			@RequestParam(defaultValue = "2") int limit,
			@RequestParam(defaultValue = "id") String sortBy
					)
	{
		return service.getAuthorList(firstName, lastName,pageNo,limit,sortBy);
	}
	
	@GetMapping("/{id}")
	public AuthorDto getAuthorByID(@PathVariable String id) throws Exception
	{
		return service.getAuthorByID(id);
	}
	
	@PostMapping
	public AuthorDto addAuthor(@Valid @RequestBody AuthorDto author)
	{
		return service.addAuthor(author);
	}
	
	@PutMapping("/{id}")
	public AuthorDto updateAuthor(@PathVariable String id,@Valid @RequestBody AuthorDto author) throws Exception
	{
		return service.updateAuthor(id, author);
	}
	
	@DeleteMapping("/{id}")
	public String deleteAuthor(@PathVariable String id)
	{
		return service.deleteAuthor(id);
	}
}
