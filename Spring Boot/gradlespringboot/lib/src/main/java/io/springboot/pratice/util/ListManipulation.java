package io.springboot.pratice.util;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

//import io.springboot.pratice.entity.Teacher;

public class ListManipulation<T> {
	public List<T> sorting(List<T> list,String sortType, Comparator<T> comparator)
	{
		if(sortType != null)
		{
			String ascType = "ASC";
			String descType = "DESC";
			
//			Comparator<T> compareByFirstName = (T o1, T o2) -> o1.getClass(). .compareTo( o2.getFirstName() );
			
			if(sortType.toUpperCase().equals(ascType))
			{	 
				Collections.sort(list, comparator);
			}
			else if(sortType.toUpperCase().equals(descType))
			{
				Collections.sort(list, comparator.reversed());
			}
		}
		return list;
	}
	
	public List<T> paging(List<T> list,int limit,int offset)
	{
		if(offset == 0)
		{
			offset = 1;
		}
		
		if(limit != 0)
		{
			int toIndex = (offset * limit);
			int fromIndex = (offset-1) *limit;
			
			if(toIndex > list.size())
			{
				toIndex = list.size();
			}
			if(fromIndex > list.size())
			{
				fromIndex = list.size();
			}
			
			List<T> subList ;
			subList = list.subList(fromIndex, toIndex);
			return subList;
		}
		return list;
	}
}
