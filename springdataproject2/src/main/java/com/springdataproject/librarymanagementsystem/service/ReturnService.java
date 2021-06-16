package com.springdataproject.librarymanagementsystem.service;

import java.util.List;

import com.springdataproject.librarymanagementsystem.dto.ReturnDto;

public interface ReturnService {
	public List<ReturnDto> getreturnbookList(String access,
			int pageno,int limit,String sortBy);
	public ReturnDto getreturnbookByID(String id);
	public ReturnDto addreturnbook(ReturnDto returnbook);
	public ReturnDto updatereturnbook(String id,ReturnDto returnbook);
	public String deletereturnbook(String id);
}
