package com.springdataproject.bookstore.dto;

import java.util.List;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

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
	@NotBlank(message = "bookName can not be blank")
	@Size(min = 3 , message = "bookName should contain atleast 3 character")
	private String bookName;
	@Digits(integer = 2, fraction = 0)
	private int edition;
	@NotNull
	private long price;
	@NotNull(message = "author required")
	private List<AuthorDto> authorsid;
	@NotNull(message = "user required")
	private UserDto userid;
}
