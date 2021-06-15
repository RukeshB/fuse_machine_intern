package com.springdataproject.bookstore.dto;

//import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

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

public class AuthorDto {
	private String id;
	@NotBlank(message = "FirstName can not be blank")
	@Size(min = 3 , message = "FirstName should contain atleast 3 character")
	private String firstName;
	@NotBlank(message = "LastName can not be blank")
	@Size(min = 3 , message = "LastName should contain atleast 3 character")
	private String lastName;
	private String address;
//	@Digits(integer = 10, fraction = 0)
	@ContactNumber(message = "phone number should be 10 digit long")
	private long phone;
}
