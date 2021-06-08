package com.pratice.springdata.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
		bookRepo.save(book);
		//bookRepo.insert(book);
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
//		return "update a book with id ="+id;
		return null;
	}

	@Override
	public String deleteBook(int id) {
		bookRepo.deleteById(id);
		return "delete a book with id ="+id;
	}

}
