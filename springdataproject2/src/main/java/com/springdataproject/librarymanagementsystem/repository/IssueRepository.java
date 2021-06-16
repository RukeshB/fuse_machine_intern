package com.springdataproject.librarymanagementsystem.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.springdataproject.librarymanagementsystem.model.Issue;

public interface IssueRepository extends MongoRepository<Issue, String>{

}
