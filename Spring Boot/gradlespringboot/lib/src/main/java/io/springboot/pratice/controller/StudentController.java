package io.springboot.pratice.controller;

import java.util.List;
import io.springboot.pratice.entity.*;
import io.springboot.pratice.service.StudentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
	
	@RequestMapping("/student/{id}")
	public StudentEntity getStudentById(@PathVariable int id)
	{
		return studentService.getStudentById(id);
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/student")
	public void addStudent(@RequestBody StudentEntity student)
	{
		studentService.addStudent(student);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value = "/student/{id}")
	public void updateStudent(@RequestBody StudentEntity student,@PathVariable int id)
	{
		studentService.updateStudent(id, student);
	}
}
