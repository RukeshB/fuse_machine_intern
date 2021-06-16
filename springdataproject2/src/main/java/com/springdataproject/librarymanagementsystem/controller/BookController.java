package com.springdataproject.librarymanagementsystem.controller;

import java.util.List;

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

import com.springdataproject.librarymanagementsystem.dto.BookDto;
import com.springdataproject.librarymanagementsystem.service.BookService;

@RestController
@RequestMapping("/books")
public class BookController {
	
	@Autowired
	BookService service;
	
	@GetMapping
	public List<BookDto> getbookList(
			@RequestParam(required = false) String bookName,
			@RequestParam(required = false) String book,
			@RequestParam(required = false) String categoryName,
			@RequestParam(defaultValue = "0") int pageNo,
			@RequestParam(defaultValue = "2") int limit,
			@RequestParam(defaultValue = "id") String sortBy
					)
	{
		return service.getbookList(bookName, book, categoryName,pageNo,limit,sortBy);
	}
	
	@GetMapping("/{id}")
	public BookDto getbookByID(@PathVariable String id) throws Exception
	{
		return service.getbookByID(id);
	}
	
	@PostMapping
	public BookDto addbook(@RequestBody BookDto book)
	{
		return service.addbook(book);
	}
	
	@PutMapping("/{id}")
	public BookDto updatebook(@PathVariable String id,@RequestBody BookDto book) throws Exception
	{
		return service.updatebook(id, book);
	}
	
	@DeleteMapping("/{id}")
	public String deletebook(@PathVariable String id)
	{
		return service.deletebook(id);
	}
}
