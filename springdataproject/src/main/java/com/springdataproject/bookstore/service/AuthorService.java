package com.springdataproject.bookstore.service;

import java.util.List;

import com.springdataproject.bookstore.dto.AuthorDto;

public interface AuthorService {
	public List<AuthorDto> getAuthorList(int pageNo, int limit, String sortBy,String firstName,String lastName);
	public AuthorDto getAuthorByID(String id);
	public AuthorDto addAuthor(AuthorDto author);
	public AuthorDto updateAuthor(String id,AuthorDto author);
	public String deleteAuthor(String id);
}
