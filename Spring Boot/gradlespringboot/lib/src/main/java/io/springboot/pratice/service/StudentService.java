package io.springboot.pratice.service;

import java.util.List;

import io.springboot.pratice.entity.StudentEntity;

public interface StudentService {
	public List<StudentEntity> getAllStudent();
	public StudentEntity getStudentById(int id);
	public void addStudent(StudentEntity student);
	public void updateStudent(int id,StudentEntity student);
	public void deleteStudent(int id);
	public List<StudentEntity> getStudentByName(String firstname);
}
