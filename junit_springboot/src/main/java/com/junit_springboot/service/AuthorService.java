package com.junit_springboot.service;

import java.util.List;

import com.junit_springboot.model.Author;

public interface AuthorService {
	public List<Author> getAuthorList();
	public Author getAuthorByid(String id);
	public Author addAuthor(Author author);
}
