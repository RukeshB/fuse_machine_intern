package com.springdataproject.bookstore.service;

import java.util.List;

import com.springdataproject.bookstore.dto.RoleDto;

public interface RoleService {
	public List<RoleDto> getRoleList();
	public RoleDto getRoleByID(String id);
	public RoleDto addRole(RoleDto role);
	public RoleDto updateRole(String id,RoleDto role);
	public String deleteRole(String id);
}
