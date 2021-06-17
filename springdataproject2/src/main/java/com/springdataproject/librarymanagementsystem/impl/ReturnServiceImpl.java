package com.springdataproject.librarymanagementsystem.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springdataproject.librarymanagementsystem.dto.IssueDto;
import com.springdataproject.librarymanagementsystem.dto.ReturnDto;
import com.springdataproject.librarymanagementsystem.model.Return;
import com.springdataproject.librarymanagementsystem.repository.ReturnRepository;
import com.springdataproject.librarymanagementsystem.service.IssueService;
import com.springdataproject.librarymanagementsystem.service.ReturnService;

@Service
public class ReturnServiceImpl implements ReturnService{

	@Autowired
	private ReturnRepository returnRepo;
	@Autowired
	private IssueService issueService;
//	@Autowired
//	private IssueRepository issueRepo;
//	private CalNoOfBooks noOfBook = new CalNoOfBooks();
	private Date today = new Date();
	
	@Override
	public List<ReturnDto> getreturnbookList(Date startingDate, Date endingDate, int pageno, int limit, String sortBy) {
		List<Return> returnList = returnRepo.findAll();
		List<ReturnDto> returnDtoList = new ArrayList<>();
		List<IssueDto> issueDto;
		
		for(Return returnBook:returnList)
		{
			issueDto = new ArrayList<>();
			for(String issueid:returnBook.getIssueID())
			{
				issueDto.add(issueService.getissueByID(issueid));
			}
			ReturnDto returnDto = ReturnDto.builder().id(returnBook.getId())
														.issues(issueDto)
														.returnDate(returnBook.getReturnDate())
														.build();
			returnDtoList.add(returnDto);
		}
		return returnDtoList;
	}

	@Override
	public ReturnDto getreturnbookByID(String id) {
		Return returnBook = returnRepo.findById(id)
				.orElseThrow(()->new IllegalStateException("Return data not Found"));
		List<IssueDto> issueDto = new ArrayList<>();
		for(String issueid:returnBook.getIssueID())
		{
			issueDto.add(issueService.getissueByID(issueid));
		}
			ReturnDto returnDto = ReturnDto.builder().id(returnBook.getId())
													.issues(issueDto)
													.returnDate(returnBook.getReturnDate())
													.build();
		return returnDto;
	}

//	public List<String> getBookIDList(ReturnDto returnbook)
//	{
//		List<String> bookIdList = new ArrayList<>();
//		for(String issueID:returnbook.getIssueID())
//		{
//			IssueDto issueDto = issueService.getissueByID(issueID);
//			//return book by adding quentity of book
//			for(BookDto bookdto:issueDto.getBooks())
//			{
//				bookIdList.add(bookdto.getId());
//			}
//			
//		}
//		return bookIdList;
//	}
	@Override
	public ReturnDto addreturnbook(ReturnDto returnbook) {
//		Issue issueModel ;
//		for(String issueID:returnbook.getIssueID())
//		{
//			issueModel = issueRepo.findById(issueID)
//					.orElseThrow(()->new IllegalStateException("Issue data not Found"));
//			noOfBook.calculate(issueModel.getBookID(), false, true);
//		}
		
//		noOfBook.calculate(getBookIDList(returnbook), false, true);
		
		for(String issueID:returnbook.getIssueID())
		{
			issueService.getissueByID(issueID);
		}
		
		Return returnBookModel = Return.builder().issueID(returnbook.getIssueID())
												.returnDate(today)
												.build();
		returnRepo.insert(returnBookModel);
		return returnbook;
	}

	@Override
	public ReturnDto updatereturnbook(String id, ReturnDto returnbook) {
		Return returnBookModel = returnRepo.findById(id)
				.orElseThrow(()->new IllegalStateException("Return data not Found"));
		
		//reissue old book by reduceing quentity of book
//		noOfBook.calculate(getBookIDList(returnbook), false, true);
		
		//return new book by adding quentity of book
//		noOfBook.calculate(getBookIDList(returnbook), false, true);
		
		for(String issueID:returnbook.getIssueID())
		{
			issueService.getissueByID(issueID);
		}
		
		returnBookModel = Return.builder().id(id)
											.issueID(returnbook.getIssueID())
											.returnDate(today)
											.build();
		returnRepo.save(returnBookModel);
		return returnbook;
	}

	@Override
	public String deletereturnbook(String id) {
		returnRepo.deleteById(id);
		return "Return with id : "+id+" is deleted";
	}

}
