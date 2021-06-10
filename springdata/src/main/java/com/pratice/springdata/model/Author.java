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

@Document(collection = "author")
public class Author {

	@Id
	private String id;
	private String firstName;
	private String lastName;
	private String address;
	private long number;
}
