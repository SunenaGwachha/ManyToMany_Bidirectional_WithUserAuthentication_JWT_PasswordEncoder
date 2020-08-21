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
import com.example.execute.api.service.CredentialService;

@RestController
@RequestMapping("/credentials")
public class CredentialController {
	
	@Autowired
	CredentialService credentialService;
	
	
	 @PostMapping(value = "/addCredentials")
	    public Credentials addCredentials(@RequestBody Credentials credentials){
	        return credentialService.addCredentials(credentials);
	    }


	    @GetMapping(value = "/getCredentials")
	    public List<Credentials> getCredentials(){
	        return credentialService.getCredentials();
	    }
	    
	    @GetMapping("/getCredentialsByCredentialsId/{credentialsId}")
	    public Credentials getByCredentialsId( @PathVariable Long credentialsId ) {    	
	    	return credentialService.findCredentialsById(credentialsId);
	    	
	    }
	    @GetMapping("/getUserByCredentialsId/{credentialsId}")
	    public User getUserByCredentialsId( @PathVariable Long credentialsId ) {
	    	
	    	Credentials cred=credentialService.findCredentialsById(credentialsId);
	    	return cred.getUser();
	    	
	    }

}
