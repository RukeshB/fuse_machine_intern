package com.springdataproject.librarymanagementsystem.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springdataproject.librarymanagementsystem.dto.AuthorDto;
import com.springdataproject.librarymanagementsystem.dto.BookDto;
import com.springdataproject.librarymanagementsystem.model.Book;
import com.springdataproject.librarymanagementsystem.repository.AuthorRepository;
import com.springdataproject.librarymanagementsystem.repository.BookRepository;
import com.springdataproject.librarymanagementsystem.service.AuthorService;
import com.springdataproject.librarymanagementsystem.service.BookService;

@Service
public class BookServiceImpl implements BookService{
	
	@Autowired
	private BookRepository bookRepo;
	@Autowired
	private AuthorRepository authorRepo;
	@Autowired
	private AuthorService authorService;

	@Override
	public List<BookDto> getbookList(String bookName, String author, String categoryName, int pageno, int limit,
			String sortBy) {
		List<Book> bookList = bookRepo.findAll();
		List<BookDto> bookDtoList = new ArrayList<>();
		List<AuthorDto> authorDtoList;
		
		for(Book book:bookList)
		{
			authorDtoList = new ArrayList<>();
			for(String authorid:book.getAuthorid())
			{
				AuthorDto authorDto = authorService.getAuthorByID(authorid);
				authorDtoList.add(authorDto);
			}
			BookDto bookDto = BookDto.builder().id(book.getId())
												.name(book.getName())
												.category(book.getCategory())
												.authors(authorDtoList)
												.quantity(book.getQuantity())
												.build();
			bookDtoList.add(bookDto);
		}
		return bookDtoList;
	}

	@Override
	public BookDto getbookByID(String id) {
		Book book = bookRepo.findById(id).orElseThrow(IllegalStateException::new);
		List<AuthorDto> authorDtoList = new ArrayList<>();

			for(String authorid:book.getAuthorid())
			{
				AuthorDto authorDto = authorService.getAuthorByID(authorid);
				authorDtoList.add(authorDto);
			}
			BookDto bookDto = BookDto.builder().id(book.getId())
												.name(book.getName())
												.category(book.getCategory())
												.authors(authorDtoList)
												.quantity(book.getQuantity())
												.build();
		
		return bookDto;
	}

	@Override
	public BookDto addbook(BookDto book) {
		List<String> authorIdList = new ArrayList<>();
		for(String authorID:book.getAuthorid())
		{
			//String authorID = authorDto.getId();
			authorIdList.add(authorID);
		}
		Book bookModel = Book.builder().name(book.getName())
									.category(book.getCategory())
									.authorid(authorIdList)
									.quantity(book.getQuantity())
									.build();
		
		bookRepo.insert(bookModel);
		return book;
	}

	@Override
	public BookDto updatebook(String id, BookDto book) {
		Book bookModel = bookRepo.findById(id).orElseThrow(IllegalStateException::new);
		List<String> authorIdList = new ArrayList<>();

		for(String authorID:book.getAuthorid())
		{
			//String authorID = authorDto.getId();
			authorIdList.add(authorID);
		}
		bookModel = Book.builder().id(id)
									.name(book.getName())
									.category(book.getCategory())
									.authorid(authorIdList)
									.quantity(book.getQuantity())
									.build();
		
		bookRepo.save(bookModel);
		return book;
	}

	@Override
	public String deletebook(String id) {
		bookRepo.deleteById(id);
		return "Book with id : "+id+" is deleted";
	}
}
