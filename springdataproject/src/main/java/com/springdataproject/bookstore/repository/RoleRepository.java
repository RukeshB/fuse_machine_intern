package com.springdataproject.bookstore.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.springdataproject.bookstore.model.Role;

public interface RoleRepository extends MongoRepository<Role, String>{

}
