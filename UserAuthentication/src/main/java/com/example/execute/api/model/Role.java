package com.example.execute.api.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="roles")
public class Role {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long role_Id;

//    @Column(nullable=false, unique=true)
//    @NotEmpty
//    @Length(max=32)
    private String role_name;

    @Override
	public String toString() {
		return "Role [role_Id=" + role_Id + ", role_name=" + role_name + ", Credentials_role=" + credentials_role + "]";
	}

	@ManyToMany(mappedBy="roles")
	  @JsonIgnoreProperties("roles")
    private List<Credentials> credentials_role;

	

	public Long getRole_Id() {
		return role_Id;
	}

	public void setRole_Id(Long role_Id) {
		this.role_Id = role_Id;
	}

	public String getRole_name() {
		return role_name;
	}

	public void setRole_name(String role_name) {
		this.role_name = role_name;
	}

	public List<Credentials> getCredentials_role() {
		return credentials_role;
	}

	public void setCredentials_role(List<Credentials> credentials_role) {
		this.credentials_role = credentials_role;
	}

	
	
   
}