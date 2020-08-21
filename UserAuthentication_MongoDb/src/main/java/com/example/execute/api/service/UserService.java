package com.example.execute.api.service;

import java.util.List;
import com.example.execute.api.model.User;

public interface UserService {

	User addUser(User user);

	List<User> getUser();

	User findUserById(String userId);

	User findByUserName(String username);

	

}
