package com.springdataproject.librarymanagementsystem.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.springdataproject.librarymanagementsystem.model.Return;

public interface ReturnRepository extends MongoRepository<Return, String>{

}
