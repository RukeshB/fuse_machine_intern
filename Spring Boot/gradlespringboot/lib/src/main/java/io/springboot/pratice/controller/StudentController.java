package io.springboot.pratice.controller;

import java.util.Arrays;
import java.util.List;
import io.springboot.pratice.entity.*;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {

	@RequestMapping("/student")
	public List<StudentEntity> getStudentDetail()
	{
		return Arrays.asList(
				new StudentEntity("Ram","Duwal","male",11,10),
				new StudentEntity("Shyam","Duwal","male",5,10),
				new StudentEntity("Sita","Suwal","female",1,10),
				new StudentEntity("Gita","Rana","female",5,9),
				new StudentEntity("Hari","karki","male",7,9),
				new StudentEntity("jhon","shimt","male",2,10),
				new StudentEntity("jack","jhonshon","male",4,10)
				);
	}
}
