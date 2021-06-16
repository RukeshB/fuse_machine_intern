package com.springdataproject.librarymanagementsystem.service;

import java.util.List;

import com.springdataproject.librarymanagementsystem.dto.BookDto;

public interface BookService {
	public List<BookDto> getbookList(String bookName,String author,String category,
			int pageno,int limit,String sortBy);
	public BookDto getbookByID(String id);
	public BookDto addbook(BookDto book);
	public BookDto updatebook(String id,BookDto book);
	public String deletebook(String id);
}
