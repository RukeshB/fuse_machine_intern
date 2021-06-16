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

@Document("books")
public class Book {
	@Id
	private String id;
	private String name;
	private String[] category;
	private List<String> authorid;
	private int quantity;
}
