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

public class UserDto {
	@Id
	private String id;
	private String firstName;
	private String lastName;
	private String email;
	private long contact;
	private List<String> roleID;
	private List<RoleDto> roles;
}
