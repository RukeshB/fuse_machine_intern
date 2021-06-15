package com.springdataproject.bookstore.dto;

import javax.validation.constraints.NotNull;

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

public class RoleDto {
	private String id;
	@NotNull(message = "role name required")
	private String role;
	@NotNull(message = "access required")
	private String[] access;
}
