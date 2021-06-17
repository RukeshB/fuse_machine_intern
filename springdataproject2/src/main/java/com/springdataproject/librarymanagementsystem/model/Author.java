package com.springdataproject.librarymanagementsystem.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.springdataproject.librarymanagementsystem.customvalidation.ContactNumber;

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

@Document("authors")
public class Author {
	@Id
	private String id;
	@NotBlank(message = "FirstName can not be blank")
	@Size(min = 3 , message = "FirstName should contain atleast 3 character")
	private String firstName;
	@NotBlank(message = "LastName can not be blank")
	@Size(min = 3 , message = "LastName should contain atleast 3 character")
	private String lastName;
	@NotNull(message = "email address required")
	@Email(message = "invalid email address")
	private String email;
	@ContactNumber(message = "contact number should be 10 digit long")
	private long contact;
}
