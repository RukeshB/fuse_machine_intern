package com.pratice.springdata.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString

@Document(collection = "Book")
public class Book {

	@Id
	private int id;
	private String bookName;
	private String authorName;
	private int edition;
	private int price;
	
	
	
}
