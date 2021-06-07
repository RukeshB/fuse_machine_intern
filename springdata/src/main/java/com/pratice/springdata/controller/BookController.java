package com.pratice.springdata.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
	
	@RequestMapping(method = RequestMethod.POST,value = "/books")
	public String addBook(@RequestBody Book book)
	{
		return bookService.addBook(book);
	}
}
