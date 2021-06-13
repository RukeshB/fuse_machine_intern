package com.springdataproject.bookstore.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder

@Document
public class Book {
	@Id
	private String id;
	private String bookName;
	private int edition;
	private long price;
	
	@DBRef
	private List<Author> authorsid;
	
	@DBRef
	private User userid;
	
}
