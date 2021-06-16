package com.springdataproject.librarymanagementsystem.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.springdataproject.librarymanagementsystem.model.Role;

public interface RoleRepository extends MongoRepository<Role, String> {

}
