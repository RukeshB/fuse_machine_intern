package io.springboot.pratice.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import io.springboot.pratice.entity.Teacher;

public class FilterTeacher{
	
	private List<Teacher> newTeacherDetail;
	private ListManipulation<Teacher> listManipulation = new ListManipulation<>();
	private Comparator<Teacher> compareByFirstName = (Teacher o1, Teacher o2) -> o1.getFirstName().compareTo( o2.getFirstName() );
	
	public List<Teacher> teacherList(List<Teacher> teachersData, String sort, int limit, int offset) {
		List<Teacher> sortedList= listManipulation.sorting(teachersData,sort, compareByFirstName);
		return listManipulation.paging(sortedList, limit, offset);
	}

//	public List<Teacher> getTeacherBySubjectAndJobType(List<Teacher> teachersData, List<String> subjects,String jobType, String sort, int limit, int offset) {
//		List<Teacher> filterByJobType = getTeacherByJobType(teachersData, jobType, sort, 0, offset);
//		return getTeacherBySubject(filterByJobType, subjects, sort, limit, offset);
//	}

	public List<Teacher> getTeacherByJobType(List<Teacher> teachersData, String jobType, String sort, int limit, int offset) {
		newTeacherDetail = new ArrayList<>(Arrays.asList());
			for(Teacher teacher:teachersData)
			{
				if(teacher.getJobType().equals(jobType))
				{
					newTeacherDetail.add(teacher);
				}
			}
			List<Teacher> sortedList= listManipulation.sorting(newTeacherDetail,sort, compareByFirstName);
			return listManipulation.paging(sortedList, limit, offset);
	}

	public List<Teacher> getTeacherBySubject(List<Teacher> teachersData, List<String> subjects, String sort, int limit, int offset) {
		newTeacherDetail = new ArrayList<>(Arrays.asList());
		int subjectFlag;
		for(Teacher teacher: teachersData)
		{	
			subjectFlag = 0;
			String[] sub = teacher.getSubjects();
			for(String indvSubject: sub)
			{
//				for(int k=0;k<subject.size();k++)
				for(String subject:subjects)
				{
					if(indvSubject.equals(subject))
					{
						subjectFlag++;
					}
				}
			}
			if(subjectFlag == subjects.size())
			{
				newTeacherDetail.add(teacher);
			}
		}
		List<Teacher> sortedList= listManipulation.sorting(newTeacherDetail,sort, compareByFirstName);
		return listManipulation.paging(sortedList, limit, offset);
	}
}
