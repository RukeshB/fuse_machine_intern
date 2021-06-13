package com.springdataproject.bookstore.service;

import java.util.List;

import com.springdataproject.bookstore.dto.BookDto;

public interface BookService {
	public List<BookDto> getBookList();
	public BookDto getBookyID(String id);
	public BookDto addBook(BookDto book);
	public BookDto updateBook(String id,BookDto book);
	public String deleteBook(String id);
}
