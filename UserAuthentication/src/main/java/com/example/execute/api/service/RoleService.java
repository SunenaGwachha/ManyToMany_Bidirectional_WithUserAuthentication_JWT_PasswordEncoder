package com.example.execute.api.service;

import java.util.List;

import com.example.execute.api.model.Role;

public interface RoleService {

	Role addRole(Role role);

	List<Role> getRole();

	Role findRoleById(Long roleId);

}
