package io.springboot.pratice.service;

import java.util.List;

import io.springboot.pratice.entity.Teachers;

public interface TeacherService {
	public List<Teachers> teacherList(String Sort);
	public Teachers getTeachersById(int id);
	public void addTeachers(Teachers teacher);
	public void updateteachers(int id, Teachers teachers);
	public void deleteTeachers(int id);
	public List<Teachers> getTeacherBySubjectAndJobType(List<String> subject,String jobType,String sort);
	public List<Teachers> getTeacherByJobType(String jobType, String sort);
	public List<Teachers> getTeacherBySubject(List<String> subject, String sort);
}
