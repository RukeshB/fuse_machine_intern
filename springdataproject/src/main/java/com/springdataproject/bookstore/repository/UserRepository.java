package com.springdataproject.bookstore.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.springdataproject.bookstore.model.User;

public interface UserRepository extends MongoRepository<User, String>{

}
