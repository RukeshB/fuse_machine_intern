package io.springboot.pratice.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.springboot.pratice.entity.Teacher;
import io.springboot.pratice.service.TeacherService;

@RestController
public class TeacherController {
	
	@Autowired
	TeacherService teacherService;

	@RequestMapping("/teachers")
	public List<Teacher> teacherList(@RequestParam(required = false) List<String> subject,
										@RequestParam(required = false) String jobType,
										@RequestParam(required = false) String sort,
										@RequestParam(required = false,defaultValue = "0") Integer limit,
										@RequestParam(required = false, defaultValue = "0") Integer offset
	)
	{
		return teacherService.filter(subject, jobType, sort, limit, offset);
	}
	
	
	
	@RequestMapping("/teachers/{id}")
	public Teacher getTeacherById(@PathVariable int id)
	{
		return teacherService.getTeachersById(id);
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/teachers")
	public void addTeacher(@Valid @RequestBody Teacher teacher)
	{
		teacherService.addTeachers(teacher);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/teachers/{id}")
	public void updateTeachers(@PathVariable int id,@Valid @RequestBody Teacher teacher)
	{
		teacherService.updateteachers(id, teacher);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/teachers/{id}")
	public void deleteTeacher(@PathVariable int id)
	{
		teacherService.deleteTeachers(id);
	}
}
