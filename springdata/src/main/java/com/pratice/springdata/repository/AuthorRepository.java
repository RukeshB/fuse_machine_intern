package com.pratice.springdata.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.pratice.springdata.model.Author;

public interface AuthorRepository extends MongoRepository<Author, String>{

}
