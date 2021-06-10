package com.pratice.springdata.controller;

import java.util.List;
import java.util.Map;

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
import org.springframework.web.bind.annotation.RequestParam;
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
	public Book getBookByID(@PathVariable String id)
	{
		return bookService.getBookByID(id);
	}
	
	@PostMapping("/books")
	public String addBook(@RequestBody Book book)
	{
		return bookService.addBook(book);
	}
	
	@PutMapping("/books/{id}")
	public String updateBook(@RequestBody Book book,@PathVariable String id)
	{
		return bookService.updateBook(book, id);
	}
	
	@DeleteMapping("/books/{id}")
	public String deleteBook(@PathVariable String id)
	{
		return bookService.deleteBook(id);
	}
	
	@GetMapping("/books/page")
	public Map<String, Object> pagination(@RequestParam(name = "pageNo", defaultValue = "0") int pageNo,
										@RequestParam(name = "limit", defaultValue = "2") int limit,
										@RequestParam(name = "sortBy", defaultValue = "id") String sortBy
			)
	{
		return bookService.pagination(pageNo, limit, sortBy);
	}
	
	//filtering query execution by example
	@GetMapping("/books/example")
	public List<Book> example(@RequestBody Book book)
	{
		return bookService.example(book);
	}
	
	//filtering using query by method name
		@GetMapping("/books/bookname")
		public List<Book> listBookByBookName(@RequestParam(name = "bookname") String bookname)
		{
			return bookService.listBookByBookName(bookname);
		}
		
		//filtering using query annotation
		@GetMapping("/books/price")
		public List<Book> filterByPrice(@RequestParam(name="price") int price)
		{
			return bookService.filterByprice(price);
		}
}
