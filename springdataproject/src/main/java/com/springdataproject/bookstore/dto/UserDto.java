package com.springdataproject.bookstore.dto;

import java.util.List;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
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

public class UserDto {
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
	@ContactNumber(message = "phone number should be 10 digit long")
	private long phone;
	@NotNull(message = "role required")
	private List<RoleDto> rolesid;
}
