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

import com.springdataproject.bookstore.dto.BookDto;
import com.springdataproject.bookstore.service.BookService;

@RestController
@RequestMapping("/books")
public class BookController {

	@Autowired
	private BookService service;
	
	@GetMapping("/")
	public List<BookDto> getBookList(@RequestParam(name = "pageNo", defaultValue = "0") int pageNo,
									@RequestParam(name = "limit", defaultValue = "2") int limit,
									@RequestParam(name = "sortBy", defaultValue = "id") String sortBy,
									@RequestParam(name = "bookName", required = false) String bookName,
									@RequestParam(name = "authorName", required = false) String authorName,
									@RequestParam(name = "startingprice", defaultValue = "0") int startingprice,
									@RequestParam(name = "endingprice", defaultValue = "0") int endingprice
			)
	{
		return service.getBookList(pageNo, limit, sortBy,bookName,authorName,startingprice,endingprice);
	}
	
	@GetMapping("/{id}")
	public BookDto getBookByID(@PathVariable String id)
	{
		return service.getBookyID(id);
	}
	
	@PostMapping("/")
	public BookDto addBook(@Valid @RequestBody BookDto book)
	{
		return service.addBook(book);
	}
	
	@PutMapping("/{id}")
	public BookDto updateBook(@Valid @RequestBody BookDto book, @PathVariable String id)
	{
		return service.updateBook(id, book);
	}
	
	@DeleteMapping("/{id}")
	public String deleteBook(@PathVariable String id)
	{
		return service.deleteBook(id);
	}
}
