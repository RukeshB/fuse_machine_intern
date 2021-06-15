package com.springdataproject.bookstore.service;

import java.util.List;

import com.springdataproject.bookstore.dto.BookDto;

public interface BookService {
	public List<BookDto> getBookList(int pageNo, int limit, String sortBy,String bookName,String authorName,int statringPrice,int endingprice);
	public BookDto getBookyID(String id);
	public BookDto addBook(BookDto book);
	public BookDto updateBook(String id,BookDto book);
	public String deleteBook(String id);
}
