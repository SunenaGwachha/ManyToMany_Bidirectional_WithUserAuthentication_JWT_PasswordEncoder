package com.example.execute.api.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.execute.api.model.Credentials;
import com.example.execute.api.repository.CredentialRepository;
import com.example.execute.api.service.CredentialService;

@Service
public class CredentialServiceImpl implements CredentialService{
	
	@Autowired
	CredentialRepository credentialRepository;
	
	@Override
	public Credentials addCredentials(Credentials credentials) {
	
		return credentialRepository.save(credentials);
	}

	@Override
	public List<Credentials> getCredentials() {
		
		return credentialRepository.findAll();
	}	

	@Override
	public Credentials findCredentialsById(Long credentialsId) {
	
		return credentialRepository.findById(credentialsId).orElse(null);
	}

	@Override
	public Credentials findByUserName(String username) {
		// TODO Auto-generated method stub
		return credentialRepository.findByUsername(username);
	}

}
