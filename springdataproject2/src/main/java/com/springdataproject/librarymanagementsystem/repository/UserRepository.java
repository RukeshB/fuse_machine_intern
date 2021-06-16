package com.springdataproject.librarymanagementsystem.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.springdataproject.librarymanagementsystem.model.User;

public interface UserRepository extends MongoRepository<User, String>{

}
