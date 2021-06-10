package com.pratice.springdata.Impl;

import java.util.List;

import com.pratice.springdata.model.Author;
import com.pratice.springdata.repository.AuthorRepository;
import com.pratice.springdata.service.AuthorService;

public class AuthorImpl implements AuthorService{

	private AuthorRepository repo;
	
	@Override
	public List<Author> authorList() {
		return repo.findAll();
	}

	@Override
	public Author getAuthorByID(String id) {
		return repo.findById(id).get();
	}

	@Override
	public String updateAuthor(String id, Author author) {
		Author newAuthor = getAuthorByID(id);
		repo.save(newAuthor);
		return "author update with id "+id;
	}

	@Override
	public String addAuthor(Author author) {
		repo.insert(author);
		return "author insert with id "+author.getId();
	}

	@Override
	public String deleteAuthor(String id) {
		repo.deleteById(id);
		return "author deleted with id "+id;
	}

}
