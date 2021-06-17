package com.springdataproject.librarymanagementsystem.util;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.springdataproject.librarymanagementsystem.dto.BookDto;
import com.springdataproject.librarymanagementsystem.service.BookService;

public class CalNoOfBooks {
	
	@Autowired
	private BookService bookService;
	private int noOfBook;
	public void calculate(List<String> booksID,boolean issuebook,boolean returnbook)
	{
		for(String bookID:booksID)
		{
			BookDto bookDto= bookService.getbookByID(bookID);
			//reduce no of book by 1 when issue
			if(issuebook == true)
			{
				noOfBook = bookDto.getQuantity()-1;
			}
			//add no of book by 1 when return
			else if(returnbook == true)
			{
				noOfBook = bookDto.getQuantity()+1;
			}
			BookDto newBookDto = BookDto.builder().id(bookID)
													.name(bookDto.getName())
													.category(bookDto.getCategory())
													.authorid(bookDto.getAuthorid())
													.quantity(noOfBook)
													.build();
			bookService.updatebook(bookDto.getId(), newBookDto);
		}
	}
}
