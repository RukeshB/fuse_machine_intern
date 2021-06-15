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
import com.springdataproject.bookstore.model.Author;
import com.springdataproject.bookstore.repository.AuthorRepository;
import com.springdataproject.bookstore.service.AuthorService;

@Service
public class AuthorServiceImpl implements AuthorService {
	
	@Autowired
	AuthorRepository repo;
	
	public List<Author> pagination(int pageNo, int limit, String sortBy,String firstName,String lastName) {
		Page<Author> authorData;
		Sort sort = Sort.by(sortBy);
		Pageable Page = PageRequest.of(pageNo, limit, sort);
		if(firstName != null && lastName == null)
		{
			authorData = repo.findByFirstName(firstName, Page);
		}
		else if(firstName == null && lastName != null)
		{
			authorData = repo.findByLastName(lastName, Page);
		}
		else if(firstName !=null && lastName != null)
		{
			authorData = repo.filterByFirstAndLastName(firstName, lastName, Page);
		}
		else
		{
			authorData = repo.findAll(Page);
		}
		return authorData.getContent();
	}
	
	@Override
	public List<AuthorDto> getAuthorList(int pageNo, int limit, String sortBy,String firstName,String lastName) {
		List<Author> authorList = pagination(pageNo, limit, sortBy,firstName,lastName);
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
	public AuthorDto addAuthor(AuthorDto author) {
		Author authorModel = Author.builder().firstName(author.getFirstName())
											.lastName(author.getLastName())
											.phone(author.getPhone())
											.address(author.getAddress())
											.build();
		repo.insert(authorModel);
		return author;
	}

	@Override
	public AuthorDto updateAuthor(String id, AuthorDto author) {
		if(repo.findById(id)!= null)
		{
			Author authorModel = Author.builder().id(id)
												.firstName(author.getFirstName())
												.lastName(author.getLastName())
												.phone(author.getPhone())
												.address(author.getAddress())
												.build();
			repo.save(authorModel);
		}
		return author;
	}

	@Override
	public String deleteAuthor(String id) {
		repo.deleteById(id);
		return "delete Author with id "+id;
	}

}
