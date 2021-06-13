package com.springdataproject.bookstore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springdataproject.bookstore.dto.RoleDto;
import com.springdataproject.bookstore.service.RoleService;

@RestController
@RequestMapping("/role")
public class RoleController {
	
	@Autowired
	RoleService service;
	
	@GetMapping("/")
	public List<RoleDto> getRoleList()
	{
		return service.getRoleList();
	}
	
	@GetMapping("/{id}")
	public RoleDto getRoleByID(@PathVariable String id)
	{
		return service.getRoleByID(id);
	}
	
	@PostMapping("/")
	public RoleDto addRole(@RequestBody RoleDto role)
	{
		return service.addRole(role);
	}
	
	@PutMapping("/{id}")
	public RoleDto updateRole(@PathVariable String id,@RequestBody RoleDto role)
	{
		return service.updateRole(id, role);
	}
	
	@DeleteMapping("/{id}")
	public String deleteRole(@PathVariable String id)
	{
		return service.deleteRole(id);
	}
}
