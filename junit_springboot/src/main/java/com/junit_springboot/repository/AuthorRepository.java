package com.junit_springboot.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.junit_springboot.model.Author;

public interface AuthorRepository extends MongoRepository<Author, String>{

}
