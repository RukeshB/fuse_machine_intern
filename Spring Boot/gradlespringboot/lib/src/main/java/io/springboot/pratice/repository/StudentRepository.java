package io.springboot.pratice.repository;


//import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import io.springboot.pratice.entity.StudentEntity;


public interface StudentRepository extends JpaRepository<StudentEntity, Integer> {
	//List<StudentEntity> findByName(String name);
}
