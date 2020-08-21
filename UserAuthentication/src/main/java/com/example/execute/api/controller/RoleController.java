package com.example.execute.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.execute.api.model.Credentials;
import com.example.execute.api.model.Role;
import com.example.execute.api.model.User;
import com.example.execute.api.service.RoleService;
import com.example.execute.api.service.UserService;

@RestController
@RequestMapping("/roles")
public class RoleController {
	
	@Autowired
	RoleService roleService;
	
	
	 @PostMapping(value = "/addRole")
	    public Role addRole(@RequestBody Role role){
	        return roleService.addRole(role);
	    }


	    @GetMapping(value = "/getRole")
	    public List<Role> getRole(){
	        return roleService.getRole();
	    }
	    
	    @GetMapping("/getRoleByRoleId/{roleId}")
	    public Role getByRoleId( @PathVariable Long roleId ) {    	
	    	return roleService.findRoleById(roleId);
	    	
	    }
	    @GetMapping("/getCrdentialByRoleId/{RoleId}")
	    public List<Credentials> getCrdentialByRoleId( @PathVariable Long RoleId ) {
	    	
	    	Role rl=roleService.findRoleById(RoleId);
	    	return rl.getCredentials_role();
	    	
	    }
	

}
