package com.example.execute.api.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.execute.api.model.Role;
import com.example.execute.api.repository.RoleRepository;
import com.example.execute.api.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService{
	
	@Autowired
	RoleRepository RoleRepository;

	@Override
	public Role addRole(Role role) {
		// TODO Auto-generated method stub
		return RoleRepository.save(role);
	}

	@Override
	public List<Role> getRole() {
		// TODO Auto-generated method stub
		return RoleRepository.findAll();
	}

	@Override
	public Role findRoleById(Long roleId) {
		// TODO Auto-generated method stub
		return RoleRepository.findById(roleId).orElse(null);
	}

}
