package com.springdataproject.bookstore.model;

import java.util.List;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

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
	@NotBlank(message = "bookName can not be blank")
	@Size(min = 3 , message = "bookName should contain atleast 3 character")
	private String bookName;
	@Digits(integer = 2, fraction = 0)
	private int edition;
	@NotNull
	private long price;
	
	@NotBlank(message = "author required")
	@DBRef
	private List<Author> authorsid;
	
	@NotBlank(message = "user required")
	@DBRef
	private User userid;
	
}
