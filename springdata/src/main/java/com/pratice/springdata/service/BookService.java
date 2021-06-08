package com.pratice.springdata.service;

import java.util.List;

import com.pratice.springdata.model.Book;

public interface BookService {

	public List<Book> bookList();
	public String addBook(Book book);
	public Book getBookByID(int id);
	public String updateBook(Book book, int id);
	public String deleteBook(int id);
}
