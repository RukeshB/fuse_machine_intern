package com.pratice.springdata.service;

import java.util.List;

import com.pratice.springdata.model.Book;

public interface BookService {

	public List<Book> bookList();
	public String addBook(Book book);
}
