package com.example.execute.api.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import com.example.execute.api.model.User;


@Repository
public interface UserRepository extends MongoRepository<User, String> {
	
	User findByUsername(String username);
}
