package com.springdataproject.librarymanagementsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springdataproject.librarymanagementsystem.dto.RoleDto;
import com.springdataproject.librarymanagementsystem.service.RoleService;

@RestController
@RequestMapping("/roles")
public class RoleController {

	@Autowired
	RoleService service;
	
	@GetMapping
	public List<RoleDto> getroleList(
			@RequestParam(required = false) String access,
			@RequestParam(defaultValue = "0") int pageNo,
			@RequestParam(defaultValue = "2") int limit,
			@RequestParam(defaultValue = "id") String sortBy
					)
	{
		return service.getroleList(access,pageNo,limit,sortBy);
	}
	
	@GetMapping("/{id}")
	public RoleDto getroleByID(@PathVariable String id) throws Exception
	{
		return service.getroleByID(id);
	}
	
	@PostMapping
	public RoleDto addrole(@RequestBody RoleDto role)
	{
		return service.addrole(role);
	}
	
	@PutMapping("/{id}")
	public RoleDto updaterole(@PathVariable String id,@RequestBody RoleDto role) throws Exception
	{
		return service.updaterole(id, role);
	}
	
	@DeleteMapping("/{id}")
	public String deleterole(@PathVariable String id)
	{
		return service.deleterole(id);
	}
}
