package com.pratice.springdata.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pratice.springdata.model.Book;
import com.pratice.springdata.service.BookService;

@RestController
public class BookController {

	@Autowired
	private BookService bookService;
	
	@RequestMapping("/books")
	public List<Book> getBooksList()
	{
		return bookService.bookList();
	}
	
	@GetMapping("/books/{id}")
	public Book getBookByID(@PathVariable int id)
	{
		return bookService.getBookByID(id);
	}
	
	@PostMapping("/books")
	public String addBook(@RequestBody Book book)
	{
		return bookService.addBook(book);
	}
	
	@PutMapping("/books/{id}")
	public String updateBook(@RequestBody Book book,@PathVariable int id)
	{
		return bookService.updateBook(book, id);
	}
	
	@DeleteMapping("/books/{id}")
	public String deleteBook(@PathVariable int id)
	{
		return bookService.deleteBook(id);
	}
}
