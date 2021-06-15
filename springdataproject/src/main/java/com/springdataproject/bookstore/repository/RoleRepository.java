package com.springdataproject.bookstore.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.springdataproject.bookstore.model.Role;

public interface RoleRepository extends MongoRepository<Role, String>{
	Page<Role> findByAccess(String access,Pageable page);
}
