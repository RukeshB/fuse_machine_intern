package com.springdataproject.bookstore.Impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.springdataproject.bookstore.dto.AuthorDto;
import com.springdataproject.bookstore.dto.BookDto;
import com.springdataproject.bookstore.dto.UserDto;
import com.springdataproject.bookstore.model.Author;
import com.springdataproject.bookstore.model.Book;
import com.springdataproject.bookstore.model.User;
import com.springdataproject.bookstore.repository.AuthorRepository;
import com.springdataproject.bookstore.repository.BookRepository;
import com.springdataproject.bookstore.repository.UserRepository;
import com.springdataproject.bookstore.service.BookService;

@Service
public class BookServiceImpl implements BookService{

	@Autowired
	BookRepository repo ;
	AuthorRepository authorRepo;
	UserRepository userRepo;
	
	public List<Book> pagination(int pageNo, int limit, String sortBy,
			String bookName,String authorName,int statringPrice,int endingprice) 
	{
		Page<Book> bookData;
		Sort sort = Sort.by(sortBy);
		Pageable Page = PageRequest.of(pageNo, limit, sort);
		if(bookName != null && authorName==null && endingprice == 0)
		{
			bookData = repo.findByBookName(bookName,Page); 
		}
		else if(bookName == null && authorName==null && endingprice != 0)
		{
			bookData = repo.filterByPriceRange(statringPrice, endingprice, Page);
		}
		else if(bookName != null && authorName==null && endingprice != 0)
		{
			bookData = repo.filterByPriceRangeAndBookName(statringPrice, endingprice,bookName, Page);
		}
		else
		{
			bookData = repo.findAll(Page);
		}
		return bookData.getContent();
	}
	
	@Override
	public List<BookDto> getBookList(int pageNo, int limit, String sortBy,
			String bookName,String authorName,int statringPrice,int endingprice) 
	{
		List<Book> bookList = pagination(pageNo, limit, sortBy,bookName,
				authorName,statringPrice,endingprice);
		List<BookDto> bookDtoList = new ArrayList<>();
		for(Book book:bookList)
		{
			List<AuthorDto> authorsDto = new ArrayList<>();
			for(Author author:book.getAuthorsid())
			{
				authorsDto.add(AuthorDto.builder().id(author.getId())
						.firstName(author.getFirstName())
						.lastName(author.getLastName())
						.build());
			}
			
//			UserDto userDto = new UserDto();
			UserDto userDto = UserDto.builder().id(book.getUserid().getId())
											.firstName(book.getUserid().getFirstName())
											.lastName(book.getUserid().getLastName())
											.phone(book.getUserid().getPhone())
											.email(book.getUserid().getEmail())
											.build();
			
			BookDto bookDto = BookDto.builder().id(book.getId())
											.bookName(book.getBookName())
											.edition(book.getEdition())
											.price(book.getPrice())
											.authorsid(authorsDto)
											.userid(userDto)
											.build();
			
			bookDtoList.add(bookDto);
		}
		return bookDtoList;
	}

	@Override
	public BookDto getBookyID(String id) {
		Book book = repo.findById(id).get();

			List<AuthorDto> authorsDto = new ArrayList<>();
			for(Author author:book.getAuthorsid())
			{
				authorsDto.add(AuthorDto.builder().id(author.getId())
						.firstName(author.getFirstName())
						.lastName(author.getLastName())
						.build());
			}
			
//			UserDto userDto = new UserDto();
			UserDto userDto = UserDto.builder().id(book.getUserid().getId())
											.firstName(book.getUserid().getFirstName())
											.lastName(book.getUserid().getLastName())
											.phone(book.getUserid().getPhone())
											.email(book.getUserid().getEmail())
											.build();
			
			BookDto bookDto = BookDto.builder().id(book.getId())
											.bookName(book.getBookName())
											.edition(book.getEdition())
											.price(book.getPrice())
											.authorsid(authorsDto)
											.userid(userDto)
											.build();
		
		return bookDto;
	}

	@Override
	public BookDto addBook(BookDto book) {
//		if(book.getAuthorsid() != null && book.getUserid()!= null)
//		{
			List<Author> authors = new ArrayList<>();
			User user;
			for(AuthorDto author:book.getAuthorsid())
			{
//				if(authorRepo.findById(author.getId()).get() != null)
//				{
//					authors.add(Author.builder().id(author.getId()).build());
//				}
//				else
//				{
//					throw new IllegalArgumentException();
//				}
				authors.add(Author.builder().id(author.getId()).build());
			}
			
//			if(userRepo.findById(book.getUserid().getId())!=null)
//			{
//				user = User.builder().id(book.getUserid().getId()).build();
//			}
//			else
//			{
//				throw new IllegalArgumentException();
//			}
			
			user = User.builder().id(book.getUserid().getId()).build();
			
			Book bookModel = Book.builder().bookName(book.getBookName())
											.edition(book.getEdition())
											.price(book.getPrice())
											.authorsid(authors)
											.userid(user)
											.build();
			repo.insert(bookModel);
//		}
		return book;
	}

	@Override
	public BookDto updateBook(String id, BookDto book) {
		if(repo.findById(id)!=null)
		{
			if(book.getAuthorsid() != null && book.getUserid()!= null)
			{
				List<Author> authors = new ArrayList<>();
				for(AuthorDto author:book.getAuthorsid())
				{
					authors.add(Author.builder().id(author.getId()).build());
				}
				User user = User.builder().id(book.getUserid().getId()).build();
				
				Book bookModel = Book.builder().id(id)
												.bookName(book.getBookName())
												.edition(book.getEdition())
												.price(book.getPrice())
												.authorsid(authors)
												.userid(user)
												.build();
				repo.save(bookModel);
			}
		}
		return book;
	}

	@Override
	public String deleteBook(String id) {
		repo.deleteById(id);
		return "delete Book with id "+id;
	}

}
