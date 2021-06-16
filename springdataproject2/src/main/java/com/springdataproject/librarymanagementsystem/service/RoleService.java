package com.springdataproject.librarymanagementsystem.service;

import java.util.List;

import com.springdataproject.librarymanagementsystem.dto.RoleDto;

public interface RoleService {
	public List<RoleDto> getroleList(String access,
			int pageno,int limit,String sortBy);
	public RoleDto getroleByID(String id);
	public RoleDto addrole(RoleDto role);
	public RoleDto updaterole(String id,RoleDto role);
	public String deleterole(String id);
}
