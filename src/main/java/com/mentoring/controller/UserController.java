package com.mentoring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mentoring.model.User;
import com.mentoring.service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {

	private final UserService userService;

	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}

	@GetMapping
	public ResponseEntity<List<User>> hello() {
		// getting all users
		return ResponseEntity.ok(userService.getAllUsers());
//		return ResponseEntity.ok("Hello, World!" + " UserController is working!");
	}

	@PostMapping("/login")
	public ResponseEntity<String> login(@RequestBody LoginRequest loginRequest) {
		System.out.println("Login request received: " + loginRequest);
		boolean isValid = userService.validateUser(loginRequest.getUsername(), loginRequest.getPassword());
		if (isValid) {
			return ResponseEntity.ok("Login successful");
		} else {
			return ResponseEntity.badRequest().body("Invalid username or password");
		}
	}


	// Inner class to represent the login request
	private static class LoginRequest {
		private String username;
		private String password;

		// Getters and setters
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

		@Override
		public String toString() {
			return "LoginRequest [username=" + username + ", password=" + password + "]";
		}

	}
}