package com.springdataproject.librarymanagementsystem.service;

import java.util.List;

import com.springdataproject.librarymanagementsystem.dto.AuthorDto;

public interface AuthorService {
	public List<AuthorDto> getAuthorList(String firstName,String LastName,
										int pageno,int limit,String sortBy);
	public AuthorDto getAuthorByID(String id);
	public AuthorDto addAuthor(AuthorDto author);
	public AuthorDto updateAuthor(String id,AuthorDto author);
	public String deleteAuthor(String id);
}
