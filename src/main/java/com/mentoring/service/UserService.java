package com.mentoring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mentoring.model.User;
import com.mentoring.repository.UserRepository;

@Service
public class UserService {

	private final UserRepository userRepository;

	@Autowired
	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	public Optional<User> getUserById(Long id) {
		return userRepository.findById(id);
	}

	public User createUser(User user) {
		return userRepository.save(user);
	}

	public boolean validateUser(String username, String password) {
		Optional<User> user = userRepository.findByUsername(username);
		System.out.println("Found user: " + user);
		return user.isPresent() && user.get().getPassword().equals(password);
	}
	// Add other methods as needed
}