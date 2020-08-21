package com.example.execute.api.service;

import java.util.List;

import com.example.execute.api.model.Credentials;

public interface CredentialService {

	List<Credentials> getCredentials();

	Credentials addCredentials(Credentials credentials);

	Credentials findCredentialsById(Long credentialsId);
	
	Credentials findByUserName(String username);

}
