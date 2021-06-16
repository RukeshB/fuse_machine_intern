package com.springdataproject.librarymanagementsystem.dto;

import org.springframework.data.annotation.Id;

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

public class AuthorDto {
	@Id
	private String id;
	private String firstName;
	private String lastName;
	private String email;
	private long contact;
}
