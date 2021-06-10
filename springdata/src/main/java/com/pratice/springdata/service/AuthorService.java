package com.pratice.springdata.service;

import java.util.List;

import com.pratice.springdata.model.Author;

public interface AuthorService {

	public List<Author> authorList();
	public Author getAuthorByID(String id);
	public String updateAuthor(String id,Author author);
	public String addAuthor(Author author);
	public String deleteAuthor(String id);
}
