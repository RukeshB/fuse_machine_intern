package com.springdataproject.bookstore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springdataproject.bookstore.dto.BookDto;
import com.springdataproject.bookstore.service.BookService;

@RestController
@RequestMapping("/books")
public class BookController {

	@Autowired
	private BookService service;
	
	@GetMapping("/")
	public List<BookDto> getBookList()
	{
		return service.getBookList();
	}
	
	@GetMapping("/{id}")
	public BookDto getBookByID(@PathVariable String id)
	{
		return service.getBookyID(id);
	}
	
	@PostMapping("/")
	public BookDto addBook(@RequestBody BookDto book)
	{
		return service.addBook(book);
	}
	
	@PutMapping("/{id}")
	public BookDto updateBook(@RequestBody BookDto book, @PathVariable String id)
	{
		return service.updateBook(id, book);
	}
	
	@DeleteMapping("/{id}")
	public String deleteBook(@PathVariable String id)
	{
		return service.deleteBook(id);
	}
}
