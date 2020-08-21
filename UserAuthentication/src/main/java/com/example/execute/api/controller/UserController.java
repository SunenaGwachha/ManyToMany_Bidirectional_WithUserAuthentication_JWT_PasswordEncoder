package com.example.execute.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.execute.api.model.Credentials;
import com.example.execute.api.model.User;
import com.example.execute.api.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
	 
	@Autowired
	UserService userService;
	
	
	 @PostMapping(value = "/addUser")
	    public User addUser(@RequestBody User user){
	        return userService.addUser(user);
	    }


	    @GetMapping(value = "/getUser")
	    public List<User> getUser(){
	        return userService.getUser();
	    }
	    
	    @GetMapping("/getUserByUserId/{userId}")
	    public User getByUserId( @PathVariable Long userId ) {    	
	    	return userService.findUserById(userId);
	    	
	    }
	    @GetMapping("/getUserCrdentialByUserId/{userId}")
	    public Credentials getUserCrdentialByUserId( @PathVariable Long userId ) {
	    	
	    	User user=userService.findUserById(userId);
	    	return user.getCredentials();
	    	
	    }
	

}

