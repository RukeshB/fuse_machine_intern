package com.springdataproject.bookstore.controller;

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

import com.springdataproject.bookstore.dto.AuthorDto;
import com.springdataproject.bookstore.service.AuthorService;

@RestController
@RequestMapping("/authors")
public class AuthorController {

	@Autowired
	AuthorService service;
	
	@GetMapping("/")
	public List<AuthorDto> getAuthorList(
								@RequestParam(name = "pageNo", defaultValue = "0") int pageNo,
								@RequestParam(name = "limit", defaultValue = "2") int limit,
								@RequestParam(name = "sortBy", defaultValue = "id") String sortBy,
								@RequestParam(name = "firstName", required = false) String firstName,
								@RequestParam(name = "lastName", required = false) String lastName
			)
	{
		return service.getAuthorList(pageNo, limit, sortBy,firstName,lastName);
	}
	
	@GetMapping("/{id}")
	public AuthorDto getAuthorByID(@PathVariable String id)
	{
		return service.getAuthorByID(id);
	}
	
	@PostMapping("/")
	public AuthorDto addAuthor(@Valid @RequestBody AuthorDto author)
	{
		return service.addAuthor(author);
	}
	
	@PutMapping("/{id}")
	public AuthorDto updateAuthor(@PathVariable String id,@Valid @RequestBody AuthorDto author)
	{
		return service.updateAuthor(id, author);
	}
	
	@DeleteMapping("/{id}")
	public String deleteAuthor(@PathVariable String id)
	{
		return service.deleteAuthor(id);
	}
}
