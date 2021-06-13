package com.springdataproject.bookstore.dto;

import java.util.List;

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

public class BookDto {
	private String id;
	private String bookName;
	private int edition;
	private long price;
	private List<AuthorDto> authorsid;
	private UserDto userid;
}
