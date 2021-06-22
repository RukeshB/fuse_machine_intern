package com.jwtauth2.pratice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.jwtauth2.pratice.model.User;

public interface UserRepository extends MongoRepository<User, String>{

	public User findByEmail(String email);
}
