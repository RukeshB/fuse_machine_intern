package com.springdataproject.bookstore.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.springdataproject.bookstore.model.User;

public interface UserRepository extends MongoRepository<User, String>{
	Page<User> findByFirstName(String firstName,Pageable page);
	Page<User> findByLastName(String lastName,Pageable page);
	
	@Query("{'firstName':'?0','lastName':'?1'}")
	Page<User> filterByFirstAndLastName(String firstName,String lastName,Pageable page);
}
