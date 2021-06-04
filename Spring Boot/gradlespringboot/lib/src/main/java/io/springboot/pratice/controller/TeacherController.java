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

import io.springboot.pratice.entity.Teachers;
import io.springboot.pratice.service.TeacherService;

@RestController
public class TeacherController {
	
	@Autowired
	TeacherService teacherService;

	@RequestMapping("/teachers")
	public List<Teachers> teacherList(@RequestParam(required = false) List<String> subject,
										@RequestParam(required = false) String jobType,
										@RequestParam(required = false) String sort
	)
	{
		if(subject != null && jobType == null)
		{
			return teacherService.getTeacherBySubject(subject,sort);
		}
		else if(subject == null && jobType != null)
		{
			return teacherService.getTeacherByJobType(jobType,sort);
		}
		else if(subject != null && jobType != null)
		{
			return teacherService.getTeacherBySubjectAndJobType(subject,jobType,sort);
		}
			return teacherService.teacherList(sort);
	}
	
	
	
	@RequestMapping("/teachers/{id}")
	public Teachers getTeacherById(@PathVariable int id)
	{
		return teacherService.getTeachersById(id);
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/teachers")
	public void addTeacher(@Valid @RequestBody Teachers teacher)
	{
		teacherService.addTeachers(teacher);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/teachers/{id}")
	public void updateTeachers(@PathVariable int id,@Valid @RequestBody Teachers teacher)
	{
		teacherService.updateteachers(id, teacher);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/teachers/{id}")
	public void deleteTeacher(@PathVariable int id)
	{
		teacherService.deleteTeachers(id);
	}
}
