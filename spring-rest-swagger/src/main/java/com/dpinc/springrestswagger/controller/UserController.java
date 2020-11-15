package com.dpinc.springrestswagger.controller;

import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dpinc.springrestswagger.exception.ResourceNotFoundException;
import com.dpinc.springrestswagger.model.User;
import com.dpinc.springrestswagger.service.UserService;

/**
 * Rest Controller for User Controller
 * @author Dhruvesh
 *
 */
@RestController
@RequestMapping("/api/v1")
public class UserController {

	@Autowired
	private UserService userService;

	/**
	 * To get health of the app
	 * @return ResponseEntity<String>  - Response entity with HTTP status code
	 */
	@GetMapping("/health")
	public ResponseEntity<String> getHealth() {
		return new ResponseEntity<String>("Successful health check - User Service", HttpStatus.OK);
	}

	/**
	 * To get all users list
	 * @return List<User> - List of all users
	 */
	@GetMapping("/users")
	public List<User> getAllUsers() {
		return userService.findAll();
	}

	/**
	 * To get user by Id
	 * @param userId - Unique user id
	 * @return ResponseEntity<User> - Response Entity with status code and user object
	 * @throws ResourceNotFoundException
	 */
	@GetMapping("/users/{id}")
	public ResponseEntity<User> getUsersById(@PathVariable(value = "id") Long userId) throws ResourceNotFoundException {

		User user = userService.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User not found for : " + userId));

		return ResponseEntity.ok().body(user);
	}

	/**
	 * To create new user
	 * @param user
	 * @return ResponseEntity<User> - Response Entity with status code and user object
	 */
	@PostMapping("/users")
	public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
		User createdUser = userService.save(user);
		return ResponseEntity.ok().body(createdUser);
	}

	/**
	 * To update existing user details
	 * @param userId
	 * @param userDetails
	 * @return ResponseEntity<User> - Response Entity with status code and user object
	 * @throws ResourceNotFoundException - Resource not found exception
	 */
	@PutMapping("/users/{id}")
	public ResponseEntity<User> updateUser(@PathVariable(value = "id") Long userId, @Valid @RequestBody User userDetails) 
			throws ResourceNotFoundException {

		User user = userService.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User not found for : " + userId));

		user.setEmail(userDetails.getEmail());
		user.setLastName(userDetails.getLastName());
		user.setFirstName(userDetails.getFirstName());
		user.setUpdatedAt(new Date());
		final User updatedUser = userService.save(user);
		return ResponseEntity.ok(updatedUser);
	}

	/**
	 * to delete existing user
	 * @param userId
	 * @return ResponseEntity<String> - Response Entity with status code and deleted user id
	 * @throws ResourceNotFoundException - Resource not found exception
	 */
	@DeleteMapping("/users/{id}")
	public ResponseEntity<String> deleteUser(@PathVariable(value = "id") Long userId) throws ResourceNotFoundException {
		User user = userService.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User not found on : " + userId));

		userService.delete(user);
		return new ResponseEntity<String>("User Deteted Successfully with user id : " + userId, HttpStatus.OK);
	}

}
