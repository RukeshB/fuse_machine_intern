package io.springboot.pratice.service;

import java.util.List;

import io.springboot.pratice.entity.Teacher;

public interface TeacherService {
	public List<Teacher> teacherList(String Sort,int limit, int offset);
	public Teacher getTeachersById(int id);
	public void addTeachers(Teacher teacher);
	public void updateteachers(int id, Teacher teachers);
	public void deleteTeachers(int id);
	public List<Teacher> filter(List<String> subject,String jobType,String sort, int limit, int offset);
}
