package com.junit_springboot.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;

import com.junit_springboot.model.Author;
import com.junit_springboot.repository.AuthorRepository;
import com.junit_springboot.service.AuthorService;

@Service
public class AuthorImpl implements AuthorService{

	@Autowired
	AuthorRepository repo;
	
	@Override
	public List<Author> getAuthorList() {
		return repo.findAll();
	}

	@Override
	public Author getAuthorByid(String id) {
		return repo.findById(id).
				orElseThrow(()->new IllegalStateException("Author data not Found"));
	}

	@Override
	public Author addAuthor(Author author) {
		repo.insert(author);
		return author;
	}

}
