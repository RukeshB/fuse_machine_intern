package com.jwtauth2.pratice.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class JwtRequest implements Serializable{
	 private static final long serialVersionUID = 5926468583005150707L;
	 
	private String userName;
	private String password;
}
