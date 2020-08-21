package com.example.execute.api.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="users")
public class User{
    
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long user_Id;
	
	private String name;
    private String email;
   
  
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_credentials_id", referencedColumnName = "credentials_Id")
    @JsonIgnoreProperties("user")
    private Credentials credentials;


	public Long getUser_Id() {
		return user_Id;
	}


	public void setUser_Id(Long user_Id) {
		this.user_Id = user_Id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}	

	public Credentials getCredentials() {
		return credentials;
	}


	public void setCredentials(Credentials credentials) {
		this.credentials = credentials;
	}


	@Override
	public String toString() {
		return "User [user_Id=" + user_Id + ", name=" + name + ", email=" + email + ", credentials=" + credentials
				+ "]";
	}


	
}
