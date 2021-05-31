package io.springboot.pratice.controller;

import java.util.List;
import io.springboot.pratice.entity.*;
import io.springboot.pratice.service.StudentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	@RequestMapping("/student")
	public List<StudentEntity> getStudentDetail()
	{
		return studentService.getAllStudent();
	}
}
