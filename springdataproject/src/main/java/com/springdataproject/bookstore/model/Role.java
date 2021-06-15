package com.springdataproject.bookstore.model;

import javax.validation.constraints.NotNull;

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
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder

@Document
public class Role {

	@Id
	private String id;
	@NotNull(message = "role name required")
	private String role;
	@NotNull(message = "access required")
	private String[] access;
}
