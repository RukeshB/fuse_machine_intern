package com.springdataproject.bookstore.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.springdataproject.bookstore.model.Author;

public interface AuthorRepository extends MongoRepository<Author, String>{
	Page<Author> findByFirstName(String firstName,Pageable page);
	Page<Author> findByLastName(String lastName,Pageable page);
	
	@Query("{'firstName':'?0','lastName':'?1'}")
	Page<Author> filterByFirstAndLastName(String firstName,String lastName,Pageable page);
}
