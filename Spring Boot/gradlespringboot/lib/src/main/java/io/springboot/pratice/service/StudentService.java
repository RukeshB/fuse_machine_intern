package io.springboot.pratice.service;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import io.springboot.pratice.entity.StudentEntity;

@Service
public class StudentService {


	private List<StudentEntity> studentList = new ArrayList<>( Arrays.asList(
			new StudentEntity(1011,"Ram","Duwal","male",11,10),
			new StudentEntity(1005,"Shyam","Duwal","male",5,10),
			new StudentEntity(1001,"Sita","Suwal","female",1,10),
			new StudentEntity(905,"Gita","Rana","female",5,9),
			new StudentEntity(907,"Hari","karki","male",7,9),
			new StudentEntity(1002,"jhon","shimt","male",2,10),
			new StudentEntity(1004,"jack","jhonshon","male",4,10)
			));
	
	public List<StudentEntity> getAllStudent()
	{
		return studentList;
	}
	
	public StudentEntity getStudentById(int id)
	{
		return studentList.stream().filter(x-> x.getId()==id).findFirst().get();
	}
	
	public void addStudent(StudentEntity student)
	{
		studentList.add(student);
	}
	
	public void updateStudent(int id,StudentEntity student)
	{
		for(int i=0;i<studentList.size();i++)
		{
			if(studentList.get(i).getId() == id)
			{
				studentList.set(i, student);
//				studentList.set(studentList.indexOf(id), student);
//				datail.setFirstName(student.getFirstName());
//				datail.setLastName(student.getLastName());
//				datail.setGender(student.getGender());
			}
		}
	}
}
