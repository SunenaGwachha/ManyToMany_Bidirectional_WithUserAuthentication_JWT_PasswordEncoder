package com.example.execute.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.execute.api.model.Credentials;


@Repository
public interface CredentialRepository  extends JpaRepository<Credentials, Long>{

	Credentials findByUsername(String username);
}
