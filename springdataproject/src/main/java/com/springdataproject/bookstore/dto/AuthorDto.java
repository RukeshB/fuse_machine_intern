package com.springdataproject.bookstore.dto;

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
	private String firstName;
	private String lastName;
	private String address;
	private long phone;
}
