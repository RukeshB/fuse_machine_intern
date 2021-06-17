package com.springdataproject.librarymanagementsystem.dto;

import java.util.List;

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

public class BookDto {
	@Id
	private String id;
	private String name;
	private String[] category;
	private List<String> authorid;
	private List<AuthorDto> authors;
	private int quantity;
}
