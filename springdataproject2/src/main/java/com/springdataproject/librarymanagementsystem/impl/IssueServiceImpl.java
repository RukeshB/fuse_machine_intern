package com.springdataproject.librarymanagementsystem.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springdataproject.librarymanagementsystem.dto.BookDto;
import com.springdataproject.librarymanagementsystem.dto.IssueDto;
import com.springdataproject.librarymanagementsystem.dto.UserDto;
import com.springdataproject.librarymanagementsystem.model.Issue;
import com.springdataproject.librarymanagementsystem.repository.IssueRepository;
import com.springdataproject.librarymanagementsystem.service.BookService;
import com.springdataproject.librarymanagementsystem.service.IssueService;
import com.springdataproject.librarymanagementsystem.service.UserService;

@Service
public class IssueServiceImpl implements IssueService{

	@Autowired
	private IssueRepository issueRepo;
	@Autowired
	private BookService bookService;
	@Autowired
	private UserService userService;
	
//	private CalNoOfBooks noOfBook = new CalNoOfBooks();
	Date today = new Date();

	@Override
	public List<IssueDto> getissueList(Date startingDate, Date endingDate, int pageno, int limit, String sortBy) {
		List<Issue> issueList = issueRepo.findAll();
		List<IssueDto> issueDtoList = new ArrayList<>();
		List<BookDto> bookDtoList ;
		
		for(Issue issue:issueList)
		{
			bookDtoList = new ArrayList<>();
			for(String booKID:issue.getBookID())
			{
				BookDto bookDto =bookService.getbookByID(booKID);
				bookDtoList.add(bookDto);
			}
			UserDto userDto = userService.getuserByID(issue.getUserID());
			IssueDto issueDto = IssueDto.builder().id(issue.getId())
													.books(bookDtoList)
													.user(userDto)
													.issueDate(issue.getIssueDate())
													.build();
			issueDtoList.add(issueDto);
		}
		return issueDtoList;
	}

	@Override
	public IssueDto getissueByID(String id) {
		Issue issue = issueRepo.findById(id)
				.orElseThrow(()->new IllegalStateException("Issue data not Found"));
		List<BookDto> bookDtoList = new ArrayList<>();
			for(String booKID:issue.getBookID())
			{
				bookDtoList.add(bookService.getbookByID(booKID));
			}
			UserDto userDto = userService.getuserByID(issue.getUserID());
			IssueDto issueDto = IssueDto.builder().id(issue.getId())
													.books(bookDtoList)
													.user(userDto)
													.issueDate(issue.getIssueDate())
													.build();

		return issueDto;
	}
	
	@Override
	public IssueDto addissue(IssueDto issue) {
		
		//check if userid is valid or not 
		userService.getuserByID(issue.getUserID());
		
		for(String bookID:issue.getBookID())
		{
			bookService.getbookByID(bookID);
		}
		
		//check if bookid is valid or not and cissue a new book
//		noOfBook.calculate(issue.getBookID(), true, false);
		
		Issue issueModel = Issue.builder().bookID(issue.getBookID())
											.userID(issue.getUserID())
											.issueDate(today)
											.build();
		issueRepo.insert(issueModel);
		return issue;
	}

	@Override
	public IssueDto updateissue(String id, IssueDto issue) {
		Issue issueModel = issueRepo.findById(id)
				.orElseThrow(()->new IllegalStateException("Issue data not Found"));
		
		//return old book
//		noOfBook.calculate(issueModel.getBookID(), false, true);
		
		//check if userid is valid or not 
		userService.getuserByID(issue.getUserID());
		
		for(String bookID:issue.getBookID())
		{
			bookService.getbookByID(bookID);
		}
		
		//check if bookid is valid or not and issue a new book
//		noOfBook.calculate(issue.getBookID(), true, false);
		
		issueModel = Issue.builder().id(id)
											.bookID(issue.getBookID())
											.userID(issue.getUserID())
											.build();
		issueRepo.save(issueModel);
		return issue;
	}

	@Override
	public String deleteissue(String id) {
		issueRepo.deleteById(id);
		return "Issue with id : "+id+" is deleted";
	}

}
