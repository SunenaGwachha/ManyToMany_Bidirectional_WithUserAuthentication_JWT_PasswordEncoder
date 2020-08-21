package com.example.execute.api.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.execute.api.model.User;
import com.example.execute.api.repository.UserRepository;
import com.example.execute.api.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserRepository userRepository;
	

	@Override
	public User addUser(User user) {
		// TODO Auto-generated method stub
		return userRepository.save(user);
	}

	@Override
	public List<User> getUser() {
		// TODO Auto-generated method stub
		return userRepository.findAll();
	}

	@Override
	public User findUserById(String userId) {
		// TODO Auto-generated method stub
		return userRepository.findById(userId).orElse(null);
	}

	@Override
	public User findByUserName(String username) {
		// TODO Auto-generated method stub
		return userRepository.findByUsername(username);
	}

}
