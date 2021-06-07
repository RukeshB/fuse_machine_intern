package com.pratice.springdata.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.pratice.springdata.model.Book;

public interface BookRepository extends MongoRepository<Book, Integer> {
	
}
