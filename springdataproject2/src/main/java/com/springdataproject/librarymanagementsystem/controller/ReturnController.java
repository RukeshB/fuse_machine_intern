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

import com.springdataproject.librarymanagementsystem.dto.ReturnDto;
import com.springdataproject.librarymanagementsystem.service.ReturnService;

@RestController
@RequestMapping("/returns")
public class ReturnController {

	@Autowired
	ReturnService service;
	
	@GetMapping
	public List<ReturnDto> getreturnList(
			@RequestParam(required = false) Date StartingDate,
			@RequestParam(required = false) Date endingDate,
			@RequestParam(defaultValue = "0") int pageNo,
			@RequestParam(defaultValue = "2") int limit,
			@RequestParam(defaultValue = "id") String sortBy
					)
	{
		return service.getreturnbookList(StartingDate, endingDate,pageNo,limit,sortBy);
	}
	
	@GetMapping("/{id}")
	public ReturnDto getreturnByID(@PathVariable String id) throws Exception
	{
		return service.getreturnbookByID(id);
	}
	
	@PostMapping
	public ReturnDto addreturn(@Valid @RequestBody ReturnDto returnBook)
	{
		return service.addreturnbook(returnBook);
	}
	
	@PutMapping("/{id}")
	public ReturnDto updatereturn(@PathVariable String id,@Valid @RequestBody ReturnDto returnBook)
	{
		return service.updatereturnbook(id, returnBook);
	}
	
	@DeleteMapping("/{id}")
	public String deletereturn(@PathVariable String id)
	{
		return service.deletereturnbook(id);
	}
}
