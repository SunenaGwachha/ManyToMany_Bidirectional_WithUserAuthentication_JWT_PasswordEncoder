package com.example.execute.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.execute.api.model.Role;


@Repository
public interface RoleRepository  extends JpaRepository<Role, Long> {


}
