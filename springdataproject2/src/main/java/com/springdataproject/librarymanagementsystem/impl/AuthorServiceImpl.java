package com.springdataproject.librarymanagementsystem.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springdataproject.librarymanagementsystem.dto.AuthorDto;
import com.springdataproject.librarymanagementsystem.model.Author;
import com.springdataproject.librarymanagementsystem.repository.AuthorRepository;
import com.springdataproject.librarymanagementsystem.service.AuthorService;

@Service
public class AuthorServiceImpl implements AuthorService{

	@Autowired
	AuthorRepository authorRepo;
	
	@Override
	public List<AuthorDto> getAuthorList(String firstName, String LastName,
										int pageno,int limit,String sortBy) {
		List<Author> authorList = authorRepo.findAll();
		List<AuthorDto> authorDtoList = new ArrayList<>();
		
		for(Author author:authorList)
		{
			AuthorDto authorDto = AuthorDto.builder().id(author.getId())
													.firstName(author.getFirstName())
													.lastName(author.getLastName())
													.contact(author.getContact())
													.email(author.getEmail())
													.build();
			authorDtoList.add(authorDto);
		}
		return authorDtoList;
	}

	@Override
	public AuthorDto getAuthorByID(String id)  {
		Author author = authorRepo.findById(id).orElseThrow(IllegalStateException::new);
//						.orElseThrow(() -> new Exception
//								("author with id: "+id+" not found")
//								);

			AuthorDto authorDto = AuthorDto.builder().id(author.getId())
													.firstName(author.getFirstName())
													.lastName(author.getLastName())
													.contact(author.getContact())
													.email(author.getEmail())
													.build();

		return authorDto;
	}

	@Override
	public AuthorDto addAuthor(AuthorDto author) {
		Author authorModel = Author.builder()
											.firstName(author.getFirstName())
											.lastName(author.getLastName())
											.contact(author.getContact())
											.email(author.getEmail())
											.build();
		authorRepo.insert(authorModel);
		return author;
	}

	@Override
	public AuthorDto updateAuthor(String id, AuthorDto author) {
		Author authorModel = authorRepo.findById(id).orElseThrow(IllegalStateException::new);
//				.orElseThrow(() -> new Exception
//						("author with id: "+id+" not found")
//						);
		
		authorModel = Author.builder().id(id)
								.firstName(author.getFirstName())
								.lastName(author.getLastName())
								.contact(author.getContact())
								.email(author.getEmail())
								.build();
		
		authorRepo.save(authorModel);
		return author;
	}

	@Override
	public String deleteAuthor(String id) {
		authorRepo.deleteById(id);
		return "Author with id : "+id+" is deleted";
	}

}
