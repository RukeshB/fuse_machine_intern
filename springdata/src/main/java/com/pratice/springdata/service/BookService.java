package com.pratice.springdata.service;

import java.util.List;
import java.util.Map;

import com.pratice.springdata.model.Book;

public interface BookService {

	public List<Book> bookList();
	public String addBook(Book book);
	public Book getBookByID(int id);
	public String updateBook(Book book, int id);
	public String deleteBook(int id);
	public Map<String, Object> pagination(int pageNo,int limit,String sortBy);
	
	//filtering query execution by example
	public List<Book> example(Book book);
	//filtering using query by method name
	public List<Book> listBookByBookName(String bookName);
	//filtering using query annotation
	public List<Book> filterByprice(int price);
}
