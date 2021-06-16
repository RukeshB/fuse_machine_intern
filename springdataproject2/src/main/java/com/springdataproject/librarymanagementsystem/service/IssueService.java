package com.springdataproject.librarymanagementsystem.service;

import java.util.List;

import com.springdataproject.librarymanagementsystem.dto.IssueDto;

public interface IssueService {
	public List<IssueDto> getissueList(String access,
			int pageno,int limit,String sortBy);
	public IssueDto getissueByID(String id);
	public IssueDto addissue(IssueDto issue);
	public IssueDto updateissue(String id,IssueDto issue);
	public String deleteissue(String id);
}
