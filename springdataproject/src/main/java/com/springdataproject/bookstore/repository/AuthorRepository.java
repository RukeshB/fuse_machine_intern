package com.springdataproject.bookstore.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.springdataproject.bookstore.model.Author;

public interface AuthorRepository extends MongoRepository<Author, String>{

}
