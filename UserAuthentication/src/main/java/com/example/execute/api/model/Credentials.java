package com.example.execute.api.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="credentials")
public class Credentials {
	

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long credentials_Id;

//    @Column(nullable=false, unique=true)
//    @NotEmpty
//    @Length(max=32)
    private String username;
    private String password;    

    @OneToOne(mappedBy = "credentials")
    @JsonIgnoreProperties("credentials")
    private User user;
    
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
    		  name = "credentials_role", 
    		  joinColumns = @JoinColumn(name = "credentials_Id"), 
    		  inverseJoinColumns = @JoinColumn(name = "role_Id"))
    @JsonIgnoreProperties("credentials_role")
    private List<Role>roles;

	

	public Long getCredentials_Id() {
		return credentials_Id;
	}

	public void setCredentials_Id(Long credentials_Id) {
		this.credentials_Id = credentials_Id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	@Override
	public String toString() {
		return "Credentials [credentials_Id=" + credentials_Id + ", username=" + username + ", password=" + password
				+ ", user=" + user + ", roles=" + roles + "]";
	}

	
}

