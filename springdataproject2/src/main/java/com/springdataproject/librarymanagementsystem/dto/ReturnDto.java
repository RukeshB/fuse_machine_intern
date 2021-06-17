package com.springdataproject.librarymanagementsystem.dto;

import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class ReturnDto {
	@Id
	private String id;
	private List<String> issueID;
	private List<IssueDto> issues;
	private Date returnDate;
}
