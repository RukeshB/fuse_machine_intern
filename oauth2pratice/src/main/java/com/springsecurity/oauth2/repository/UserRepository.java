package com.springsecurity.oauth2.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.springsecurity.oauth2.model.User;

public interface UserRepository extends MongoRepository<User, String>{
	public User findByUserName(String userName);
}
