package com.practise.socialMediaApp.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.practise.socialMediaApp.daoService.UserDaoService;
import com.practise.socialMediaApp.exception.UserNotFoundException;
import com.practise.socialMediaApp.model.User;

import jakarta.validation.Valid;

@RestController
public class UserResource {

	@Autowired
	private UserDaoService service;

	// constructor injection
	public UserResource(UserDaoService service) {
		this.service = service;
	}

	// method to retrieve all the users
	@GetMapping("/users")
	public List<User> retrieveAllUsers() {
		return service.findAll();
	}

	// method to retrieve one specific user
	@GetMapping("/users/{id}")
	public User retrieveUsers(@PathVariable int id) {
//		return service.findOne(id);
		User user = service.findOne(id);
		if(user==null) {
			throw new UserNotFoundException("id:"+id);
		}
		return user;
	}

	// create a user
	// we need name and birthdate to create a user and id is created by the app
	/*
	 * @Request body is used to have something that has a same structure and the
	 * content is sent as a part of request body so therefore we use request body
	 * annotation
	 */

	/*
	 * For correct response code we have added ResponseEntity.created(null).build();
	 */
	@PostMapping("/users")
	public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
		// changed from public User createUser(@RequestBody User user)
		// return service.save(user);
		// service.save(user); // changed to get the location for newly created item
		User savedUser = service.save(user);
		// To get the url for newly created item so that it can be checked from the
		// response body
		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(savedUser.getId())
				.toUri();
		return ResponseEntity.created(location).build();
	}
	
	
	@DeleteMapping("/users/{id}")
	public void deleteUser(@PathVariable int id) {
//		return service.findOne(id);
		service.deleteById(id);
//		if(user==null) {
//			throw new UserNotFoundException("id:"+id);
//		}
	}
	
	
	
}
