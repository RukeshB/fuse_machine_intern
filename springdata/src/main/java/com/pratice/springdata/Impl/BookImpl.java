package com.pratice.springdata.Impl;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.lang.model.element.Element;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.pratice.springdata.model.Book;
import com.pratice.springdata.repository.BookRepository;
import com.pratice.springdata.service.BookService;

@Service
public class BookImpl implements BookService{

	@Autowired
	private BookRepository bookRepo;
	
	@Override
	public List<Book> bookList() {
		return bookRepo.findAll();
	}

	@Override
	public String addBook(Book book) {
//		bookRepo.save(book);
		bookRepo.insert(book);
		return "Book insert successfully";
	}

	@Override
	public Book getBookByID(int id) {
		return bookRepo.findById(id).get();
	}

	@Override
	public String updateBook(Book book, int id) {
		Book bookByID = bookRepo.findById(id).get();
		bookByID = book;
		bookRepo.save(bookByID);
		return "update a book with id ="+id;
//		return null;
	}

	@Override
	public String deleteBook(int id) {
		bookRepo.deleteById(id);
		return "delete a book with id ="+id;
	}

	//pagination and sorting
	@Override
	public Map<String, Object> pagination(int pageNo, int limit, String sortBy) {
		Map<String, Object> response = new HashMap<String,Object>();
		Sort sort = Sort.by(sortBy);
		Pageable Page = PageRequest.of(pageNo, limit, sort);
		Page<Book> bookData = bookRepo.findAll(Page);
		response.put("data", bookData.getContent());
		response.put("pageNo", bookData.getNumber());
		response.put("limit", bookData.getSize());
		response.put("Total page", bookData.getTotalPages());
		response.put("Total Number of Element", bookData.getTotalElements());
		return response;
	}

	@Override
	public List<Book> example(Book book) {
		Example<Book> e = Example.of(book);
		return bookRepo.findAll(e);
	}

	@Override
	public List<Book> listBookByBookName(String bookName) {
		
		return bookRepo.findByBookNameStartingWith(bookName);
	}

	@Override
	public List<Book> filterByprice(int price) {
		return bookRepo.filterByprice(price);
	}

	
}
