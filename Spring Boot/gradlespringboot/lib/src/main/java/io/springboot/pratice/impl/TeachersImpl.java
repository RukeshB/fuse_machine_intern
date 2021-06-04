package io.springboot.pratice.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.springboot.pratice.entity.Teachers;
import io.springboot.pratice.service.TeacherService;

@Service
public class TeachersImpl implements TeacherService{

	private List<Teachers> teachersData = new ArrayList<>(Arrays.asList(
			new Teachers(1,"subin","karki",new String[] {"math","opt.math"},"full time"),
			new Teachers(2,"jhon","smit",new String[] {"english","grammer"},"full time"),
			new Teachers(3,"babin","duwal",new String[] {"computer"},"part time"),
			new Teachers(4,"subin","karki",new String[] {"science"},"part time"),
			new Teachers(5,"season","jhonshon",new String[] {"science","math"},"part time")
			));
	private List<Teachers> newTeacherDetail;
	
	public List<Teachers> sorting(List<Teachers> teacherList,String sortType)
	{
		if(sortType != null)
		{
			String ascType = "ASC";
			String descType = "DESC";
			
			Comparator<Teachers> compareById = (Teachers o1, Teachers o2) -> o1.getFirstName().compareTo( o2.getFirstName() );
			
			if(sortType.toUpperCase().equals(ascType))
			{	 
				Collections.sort(teacherList, compareById);
			}
			else if(sortType.toUpperCase().equals(descType))
			{
				Collections.sort(teacherList, compareById.reversed());
			}
		}
		return teacherList;
	}
	
	@Override
	public List<Teachers> teacherList(String sort) {
		return sorting(teachersData, sort);
		//return teachersData;
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

	@Override
	public List<Teachers> getTeacherBySubjectAndJobType(List<String> subject,String jobType, String sort) {
		newTeacherDetail = new ArrayList<>(Arrays.asList());
			int subjectFlag;
			for(Teachers teacher: teachersData)
			{	
				subjectFlag = 0;
				String[] sub = teacher.getSubjects();
				for(int j=0;j<sub.length;j++)
				{
					for(int k=0;k<subject.size();k++)
					{
						if(sub[j].equals(subject.get(k)))
						{
							subjectFlag++;
						}
					}
				}
				if(subjectFlag == subject.size())
				{
					if(teacher.getJobType().equals(jobType))
					{
						newTeacherDetail.add(teacher);
					}
				}
			}
		//return newTeacherDetail;
		return sorting(newTeacherDetail, sort);
	}

	@Override
	public List<Teachers> getTeacherByJobType(String jobType, String sort) {
		newTeacherDetail = new ArrayList<>(Arrays.asList());
			for(Teachers teacher:teachersData)
			{
				if(teacher.getJobType().equals(jobType))
				{
					newTeacherDetail.add(teacher);
				}
			}
			//return newTeacherDetail;
			return sorting(newTeacherDetail, sort);
	}

	@Override
	public List<Teachers> getTeacherBySubject(List<String> subject, String sort) {
		newTeacherDetail = new ArrayList<>(Arrays.asList());
		int subjectFlag;
		for(Teachers teacher: teachersData)
		{	
			subjectFlag = 0;
			String[] sub = teacher.getSubjects();
			for(int j=0;j<sub.length;j++)
			{
				for(int k=0;k<subject.size();k++)
				{
					if(sub[j].equals(subject.get(k)))
					{
						subjectFlag++;
					}
				}
			}
			if(subjectFlag == subject.size())
			{
				newTeacherDetail.add(teacher);
			}
		}
	//return newTeacherDetail;
	return sorting(newTeacherDetail, sort);
	}

}
