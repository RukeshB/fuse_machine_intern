package com.springdataproject.librarymanagementsystem.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.springdataproject.librarymanagementsystem.model.Author;

public interface AuthorRepository extends MongoRepository<Author, String>{

}
