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

public class UserDto {
	private String id;
	private String firstName;
	private String lastName;
	private String email;
	private long phone;
	private List<RoleDto> rolesid;
}
