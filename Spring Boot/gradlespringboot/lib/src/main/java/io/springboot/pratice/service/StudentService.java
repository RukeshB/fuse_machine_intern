package io.springboot.pratice.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import io.springboot.pratice.entity.StudentEntity;

@Service
public class StudentService {


	private List<StudentEntity> studentList = Arrays.asList(
			new StudentEntity("Ram","Duwal","male",11,10),
			new StudentEntity("Shyam","Duwal","male",5,10),
			new StudentEntity("Sita","Suwal","female",1,10),
			new StudentEntity("Gita","Rana","female",5,9),
			new StudentEntity("Hari","karki","male",7,9),
			new StudentEntity("jhon","shimt","male",2,10),
			new StudentEntity("jack","jhonshon","male",4,10)
			);
	
	public List<StudentEntity> getAllStudent()
	{
		return studentList;
	}
}
