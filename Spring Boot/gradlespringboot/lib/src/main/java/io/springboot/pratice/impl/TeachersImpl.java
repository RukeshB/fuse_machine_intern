package io.springboot.pratice.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.stereotype.Service;

import io.springboot.pratice.entity.Teacher;
import io.springboot.pratice.service.TeacherService;
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
	private List<Teacher> newTeacherDetail;
	private ListManipulation<Teacher> listManipulation = new ListManipulation<>();
	private Comparator<Teacher> compareByFirstName = (Teacher o1, Teacher o2) -> o1.getFirstName().compareTo( o2.getFirstName() );
	
	public List<Teacher> sorting(List<Teacher> teacherList,String sortType)
	{
		if(sortType != null)
		{
			String ascType = "ASC";
			String descType = "DESC";
			
			Comparator<Teacher> compareByFirstName = (Teacher o1, Teacher o2) -> o1.getFirstName().compareTo( o2.getFirstName() );
//			Comparator<Teacher> compareByFirstName = (Comparator<Teacher>) teacherList;
			if(sortType.toUpperCase().equals(ascType))
			{	 
				Collections.sort(teacherList, compareByFirstName);
			}
			else if(sortType.toUpperCase().equals(descType))
			{
				Collections.sort(teacherList, compareByFirstName.reversed());
			}
		}
		return teacherList;
	}
	
	public List<Teacher> paging(List<Teacher> teacherList,int limit,int offset)
	{
		if(offset == 0)
		{
			offset = 1;
		}
		
		if(limit != 0)
		{
			int toIndex = (offset * limit);
			int fromIndex = (offset-1) *limit;
			
			if(toIndex > teacherList.size())
			{
				toIndex = teacherList.size();
			}
			if(fromIndex > teacherList.size())
			{
				fromIndex = teacherList.size();
			}
			
			List<Teacher> subList ;
			subList = teacherList.subList(fromIndex, toIndex);
			return subList;
		}
		return teacherList;
	}
	
	@Override
	public List<Teacher> teacherList(String sort, int limit, int offset) {
//		return paging(sorting(teachersData, sort),limit,offset);
//		Comparator<Teacher> compareByFirstName = (Teacher o1, Teacher o2) -> o1.getFirstName().compareTo( o2.getFirstName() );
		List<Teacher> sortedList= listManipulation.sorting(teachersData,sort, compareByFirstName);
		return listManipulation.paging(sortedList, limit, offset);
	}

	@Override
	public Teacher getTeachersById(int id) {
		return teachersData.stream().filter(x->x.getId()==id).findFirst().get();
	}

	@Override
	public void updateteachers(int id, Teacher teachers) {
		//for(int i=0; i<teachersData.size();i++)
		for(Teacher teacher:teachersData)
		{
//			if(teachersData.get(i).getId() == id)
				if(teacher.getId() == id)
			{
//				teachersData.set(i, teachers);
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

	public List<Teacher> getTeacherBySubjectAndJobType(List<String> subject,String jobType, String sort, int limit, int offset) {
		newTeacherDetail = new ArrayList<>(Arrays.asList());
			int subjectFlag;
			for(Teacher teacher: teachersData)
			{	
				subjectFlag = 0;
				String[] sub = teacher.getSubjects();
//				for(int j=0;j<sub.length;j++)
				for(String indvSubject: sub)
				{
					for(int k=0;k<subject.size();k++)
					{
						if(indvSubject.equals(subject.get(k)))
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
//		return sorting(newTeacherDetail, sort);
//			return paging(sorting(newTeacherDetail, sort),limit,offset);
			List<Teacher> sortedList= listManipulation.sorting(newTeacherDetail,sort, compareByFirstName);
			return listManipulation.paging(sortedList, limit, offset);
	}

	public List<Teacher> getTeacherByJobType(String jobType, String sort, int limit, int offset) {
		newTeacherDetail = new ArrayList<>(Arrays.asList());
			for(Teacher teacher:teachersData)
			{
				if(teacher.getJobType().equals(jobType))
				{
					newTeacherDetail.add(teacher);
				}
			}
			//return newTeacherDetail;
//			return sorting(newTeacherDetail, sort);
//			return paging(sorting(newTeacherDetail, sort),limit,offset);
			List<Teacher> sortedList= listManipulation.sorting(newTeacherDetail,sort, compareByFirstName);
			return listManipulation.paging(sortedList, limit, offset);
	}

	public List<Teacher> getTeacherBySubject(List<String> subject, String sort, int limit, int offset) {
		newTeacherDetail = new ArrayList<>(Arrays.asList());
		int subjectFlag;
		for(Teacher teacher: teachersData)
		{	
			subjectFlag = 0;
			String[] sub = teacher.getSubjects();
			//for(int j=0;j<sub.length;j++)
			for(String indvSubject: sub)
			{
				for(int k=0;k<subject.size();k++)
				{
//					if(sub[j].equals(subject.get(k)))
					if(indvSubject.equals(subject.get(k)))
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
//		return paging(sorting(newTeacherDetail, sort),limit,offset);
		List<Teacher> sortedList= listManipulation.sorting(newTeacherDetail,sort, compareByFirstName);
		return listManipulation.paging(sortedList, limit, offset);
	}

	@Override
	public List<Teacher> filter(List<String> subject, String jobType, String sort, int limit, int offset) {
		if(subject != null && jobType == null)
		{
			return getTeacherBySubject(subject,sort,limit,offset);
		}
		else if(subject == null && jobType != null)
		{
			return getTeacherByJobType(jobType,sort,limit,offset);
		}
		else if(subject != null && jobType != null)
		{
			return getTeacherBySubjectAndJobType(subject,jobType,sort,limit,offset);
		}
		return teacherList(sort,limit,offset);
	}

}
