package com.springdataproject.bookstore.Impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springdataproject.bookstore.dto.AuthorDto;
import com.springdataproject.bookstore.model.Author;
import com.springdataproject.bookstore.repository.AuthorRepository;
import com.springdataproject.bookstore.service.AuthorService;

@Service
public class AuthorServiceImpl implements AuthorService {
	
	@Autowired
	AuthorRepository repo;
	
	@Override
	public List<AuthorDto> getAuthorList() {
		List<Author> authorList = repo.findAll();
		List<AuthorDto> authorDtoList = new ArrayList<>();
		
		for(Author author:authorList)
		{
			AuthorDto authorDto = AuthorDto.builder().id(author.getId())
													.firstName(author.getFirstName())
													.lastName(author.getLastName())
													.phone(author.getPhone())
													.address(author.getAddress())
													.build();
			authorDtoList.add(authorDto);
		}
		return authorDtoList;
	}

	@Override
	public AuthorDto getAuthorByID(String id) {
		Author author = repo.findById(id).get();

		AuthorDto authorDto = AuthorDto.builder().id(author.getId())
				.firstName(author.getFirstName())
				.lastName(author.getLastName())
				.phone(author.getPhone())
				.address(author.getAddress())
				.build();
		
		return authorDto;
	}

	@Override
	public AuthorDto addAuthor(AuthorDto role) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AuthorDto updateAuthor(String id, AuthorDto role) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteAuthor(String id) {
		// TODO Auto-generated method stub
		return null;
	}

}
