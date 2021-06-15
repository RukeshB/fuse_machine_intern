package com.springdataproject.bookstore.model;

//import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

//import org.hibernate.validator.constraints.Range;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.springdataproject.bookstore.customvalidation.ContactNumber;

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
public class Author {
	@Id
	private String id;
	@NotBlank(message = "FirstName can not be blank")
	@Size(min = 3 , message = "FirstName should contain atleast 3 character")
	private String firstName;
	@NotBlank(message = "LastName can not be blank")
	@Size(min = 3 , message = "LastName should contain atleast 3 character")
	private String lastName;
	private String address;
	//@Digits(integer = 10, fraction = 0,message = "phone number should content 10 digit")
	@ContactNumber(message = "phone number should be 10 digit long")
	private long phone;
}
