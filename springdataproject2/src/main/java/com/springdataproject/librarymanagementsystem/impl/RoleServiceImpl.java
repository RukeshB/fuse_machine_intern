package com.springdataproject.librarymanagementsystem.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springdataproject.librarymanagementsystem.dto.RoleDto;
import com.springdataproject.librarymanagementsystem.model.Role;
import com.springdataproject.librarymanagementsystem.repository.RoleRepository;
import com.springdataproject.librarymanagementsystem.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService{

	@Autowired
	private RoleRepository roleRepo;

	@Override
	public List<RoleDto> getroleList(String access, int pageno, int limit, String sortBy) {
		List<Role> roleList = roleRepo.findAll();
		List<RoleDto> roleDtoList = new ArrayList<>();
		
		for(Role role:roleList)
		{
			RoleDto roleDto = RoleDto.builder().id(role.getId())
									.role(role.getRole())
									.access(role.getAccess())
									.build();
			
			roleDtoList.add(roleDto);
		}
		return roleDtoList;
	}

	@Override
	public RoleDto getroleByID(String id) {
		Role role = roleRepo.findById(id)
				.orElseThrow(()->new IllegalStateException("Role data not Found"));
//				.orElseThrow(
//				()->new Exception("role with id: "+id+" not found"));
		
			RoleDto roleDto = RoleDto.builder().id(role.getId())
									.role(role.getRole())
									.access(role.getAccess())
									.build();
			
		return roleDto;
	}

	@Override
	public RoleDto addrole(RoleDto role) {
		Role roleModel = Role.builder()
									.role(role.getRole())
									.access(role.getAccess())
									.build();
		
		roleRepo.insert(roleModel);
		return role;
	}

	@Override
	public RoleDto updaterole(String id, RoleDto role) {
		Role roleModel = roleRepo.findById(id)
				.orElseThrow(()->new IllegalStateException("Role data not Found"));
//				.orElseThrow(
//				()->new Exception("role with id: "+id+" not found"));
		
		roleModel = Role.builder().id(id)
								.role(role.getRole())
								.access(role.getAccess())
								.build();

		roleRepo.save(roleModel);
		return role;
	}

	@Override
	public String deleterole(String id) {
		roleRepo.deleteById(id);
		return "role with id: "+id+" deleted";
	}
}
