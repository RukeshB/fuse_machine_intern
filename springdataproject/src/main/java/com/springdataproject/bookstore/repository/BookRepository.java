package com.springdataproject.bookstore.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.springdataproject.bookstore.model.Book;

public interface BookRepository extends MongoRepository<Book, String>{

}
