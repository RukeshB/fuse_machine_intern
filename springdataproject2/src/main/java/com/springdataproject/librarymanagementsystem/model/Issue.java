package com.springdataproject.librarymanagementsystem.model;

import java.util.Date;
import java.util.List;

import javax.validation.constraints.NotBlank;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

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

@Document("issue")
public class Issue {
	@Id
	private String id;
	@NotBlank(message = "bookID can not be blank")
	private List<String> bookID;
	@NotBlank(message = "userID can not be blank")
	private String userID;
	private Date issueDate;
}
