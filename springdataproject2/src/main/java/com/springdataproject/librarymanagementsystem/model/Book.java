package com.springdataproject.librarymanagementsystem.model;

import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

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

@Document("books")
public class Book {
	@Id
	private String id;
	@NotBlank(message = "BookName can not be blank")
	@Size(min = 3 , message = "BookName should contain atleast 3 character")
	private String name;
	@NotBlank(message = "category can not be blank")
	private String[] category;
	@NotBlank(message = "authorid can not be blank")
	private List<String> authorid;
	@NotBlank(message = "quantity can not be blank")
	private int quantity;
}
