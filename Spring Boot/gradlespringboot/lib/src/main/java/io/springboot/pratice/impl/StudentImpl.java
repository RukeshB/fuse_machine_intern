package io.springboot.pratice.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.springframework.stereotype.Service;

import io.springboot.pratice.entity.StudentEntity;
import io.springboot.pratice.service.StudentService;

@Service

public class StudentImpl implements StudentService{
	
	private List<StudentEntity> studentList = new ArrayList<>( Arrays.asList(
			new StudentEntity(1011,"Ram","Duwal","male",11,10),
			new StudentEntity(1005,"Shyam","Duwal","male",5,10),
			new StudentEntity(1001,"Sita","Suwal","female",1,10),
			new StudentEntity(905,"Gita","Rana","female",5,9),
			new StudentEntity(907,"Hari","karki","male",7,9),
			new StudentEntity(1002,"jhon","shimt","male",2,10),
			new StudentEntity(1004,"jack","jhonshon","male",4,10)
			));
	
	@Override
	public List<StudentEntity> getAllStudent()
	{
		//return studentRepo.findAll();
		return studentList;
	}
	
	@Override
	public StudentEntity getStudentById(int id)
	{
		return studentList.stream().filter(x-> x.getId()==id).findFirst().get();
		//return studentRepo.findById(id).get();
	}
	
	@Override
	public void addStudent(StudentEntity student)
	{
		studentList.add(student);
	}
	
	@Override
	public void updateStudent(int id,StudentEntity student)
	{
		for(int i=0;i<studentList.size();i++)
		{
			if(studentList.get(i).getId() == id)
			{
				studentList.set(i, student);
			}
		}
	}
	
	@Override
	public void deleteStudent(int id)
	{
		for(int i=0;i<studentList.size();i++)
		{
			if(studentList.get(i).getId() == id)
			{
				studentList.remove(i);
			}
		}
	}

	@Override
	public List<StudentEntity> getStudentByName(String firstname) {
		
		return null;
		//return studentRepo.findByFirstName(firstname);
	}
	
	
}
