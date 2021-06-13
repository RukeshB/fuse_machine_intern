package com.springdataproject.bookstore.Impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springdataproject.bookstore.dto.RoleDto;
import com.springdataproject.bookstore.model.Role;
import com.springdataproject.bookstore.repository.RoleRepository;
import com.springdataproject.bookstore.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService {

	@Autowired
	RoleRepository repo;
	
	@Override
	public List<RoleDto> getRoleList() {
		List<Role> roleList = repo.findAll();
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
	public RoleDto getRoleByID(String id) {
		Role role = repo.findById(id).get();

			RoleDto roleDto = RoleDto.builder().id(role.getId())
									.role(role.getRole())
									.access(role.getAccess())
									.build();

		return roleDto;
	}

	@Override
	public RoleDto addRole(RoleDto role) {
		Role roleModel = Role.builder().id(role.getId())
				.role(role.getRole())
				.access(role.getAccess())
				.build();
		repo.insert(roleModel);
		return role;
	}

	@Override
	public RoleDto updateRole(String id, RoleDto role) {
		if(repo.findById(id)!=null)
		{
			Role roleModel = Role.builder().id(role.getId())
					.role(role.getRole())
					.access(role.getAccess())
					.build();
			repo.insert(roleModel);
			return role;
		}
		return null;
	}

	@Override
	public String deleteRole(String id) {
		repo.deleteById(id);
		return "delete role with id "+id;
	}

}
