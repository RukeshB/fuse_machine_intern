package io.springboot.pratice.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import io.springboot.pratice.entity.Teachers;
import io.springboot.pratice.service.TeacherService;

@Service
public class TeachersImpl implements TeacherService{

	private List<Teachers> teachersData = new ArrayList<>(Arrays.asList(
			new Teachers(1,"subin","karki",new String[] {"math","opt.math"},"full time"),
			new Teachers(2,"jhon","smit",new String[] {"english","grammer"},"full time"),
			new Teachers(3,"babin","duwal",new String[] {"computer"},"part time"),
			new Teachers(4,"subin","karki",new String[] {"science"},"part time")
			));
	
	@Override
	public List<Teachers> teacherList() {
		return teachersData;
	}

	@Override
	public Teachers getTeachersById(int id) {
		return teachersData.stream().filter(x->x.getId()==id).findFirst().get();
	}

	@Override
	public void updateteachers(int id, Teachers teachers) {
		for(int i=0; i<teachersData.size();i++)
		{
			if(teachersData.get(i).getId() == id)
			{
				teachersData.set(i, teachers);
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
	public void addTeachers(Teachers teacher) {
		teachersData.add(teacher);
	}

}
