package com.springdataproject.librarymanagementsystem.controller;

import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springdataproject.librarymanagementsystem.dto.IssueDto;
import com.springdataproject.librarymanagementsystem.service.IssueService;

@RestController
@RequestMapping("/issues")
public class IssueController {
	
	@Autowired
	IssueService service;
	
	@GetMapping
	public List<IssueDto> getissueList(
			@RequestParam(required = false) Date StartingDate,
			@RequestParam(required = false) Date endingDate,
			@RequestParam(defaultValue = "0") int pageNo,
			@RequestParam(defaultValue = "2") int limit,
			@RequestParam(defaultValue = "id") String sortBy
					)
	{
		return service.getissueList(StartingDate, endingDate,pageNo,limit,sortBy);
	}
	
	@GetMapping("/{id}")
	public IssueDto getissueByID(@PathVariable String id)
	{
		return service.getissueByID(id);
	}
	
	@PostMapping
	public IssueDto addissue(@Valid @RequestBody IssueDto issue)
	{
		return service.addissue(issue);
	}
	
	@PutMapping("/{id}")
	public IssueDto updateissue(@PathVariable String id,@Valid @RequestBody IssueDto issue) throws Exception
	{
		return service.updateissue(id, issue);
	}
	
	@DeleteMapping("/{id}")
	public String deleteissue(@PathVariable String id)
	{
		return service.deleteissue(id);
	}
}
