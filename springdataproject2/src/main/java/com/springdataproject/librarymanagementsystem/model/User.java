package com.springdataproject.librarymanagementsystem.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

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

@Document("users")
public class User {
	@Id
	private String id;
	private String firstName;
	private String lastName;
	private String email;
	private long contact;
	private List<String> roleID;
}
