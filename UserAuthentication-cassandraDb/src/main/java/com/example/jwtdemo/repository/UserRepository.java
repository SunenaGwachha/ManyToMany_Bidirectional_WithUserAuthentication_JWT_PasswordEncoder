package com.example.jwtdemo.repository;

import com.example.jwtdemo.model.User;
import org.springframework.data.cassandra.repository.CassandraRepository;

import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CassandraRepository<User,String> {
    User findByUsername(String username);
}
