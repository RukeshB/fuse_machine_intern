package com.springsecurity.oauth2.dto;

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
	private String userName;
	private String password;
	private String email;
	private List<String> roles;
}
