package io.springboot.pratice.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.stereotype.Service;

import io.springboot.pratice.entity.Teacher;
import io.springboot.pratice.service.TeacherService;
import io.springboot.pratice.util.FilterTeacher;
import io.springboot.pratice.util.ListManipulation;

@Service
public class TeachersImpl implements TeacherService{

	private List<Teacher> teachersData = new ArrayList<>(Arrays.asList(
			new Teacher(1,"subin","karki",new String[] {"math","opt.math"},"full time"),
			new Teacher(2,"jhon","smit",new String[] {"english","grammer"},"full time"),
			new Teacher(3,"babin","duwal",new String[] {"computer"},"part time"),
			new Teacher(4,"subin","karki",new String[] {"science"},"part time"),
			new Teacher(5,"season","jhonshon",new String[] {"science","math"},"part time")
			));
	private FilterTeacher filterTeacherData = new FilterTeacher();
	
	@Override
	public Teacher getTeachersById(int id) {
		return teachersData.stream().filter(x->x.getId()==id).findFirst().get();
	}

	@Override
	public void updateteachers(int id, Teacher teachers) {
		for(Teacher teacher:teachersData)
		{
				if(teacher.getId() == id)
			{
				teachersData.set(teachersData.indexOf(teachers), teachers);	
			}
		}
	}

	@Override
	public void deleteTeachers(int id) {
		for(int i=0; i<teachersData.size();i++)
		{
			if(teachersData.get(i).getId() == id)
			{
				teachersData.remove(i);
			}
		}
	}

	@Override
	public void addTeachers(Teacher teacher) {
		teachersData.add(teacher);
	}

	@Override
	public List<Teacher> filter(List<String> subject, String jobType, String sort, int limit, int offset) {
		if(subject != null && jobType == null)
		{
			return filterTeacherData.getTeacherBySubject(teachersData,subject,sort,limit,offset);
		}
		else if(subject == null && jobType != null)
		{
			return filterTeacherData.getTeacherByJobType(teachersData,jobType,sort,limit,offset);
		}
		else if(subject != null && jobType != null)
		{
			return filterTeacherData.getTeacherBySubjectAndJobType(teachersData,subject,jobType,sort,limit,offset);
		}
		return filterTeacherData.teacherList(teachersData,sort,limit,offset);
	}

}
