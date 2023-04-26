package com.practise.socialMediaApp.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
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
import com.practise.socialMediaApp.model.Post;
import com.practise.socialMediaApp.model.User;
import com.practise.socialMediaApp.repository.jpaRepository.PostRepository;
import com.practise.socialMediaApp.repository.jpaRepository.UserRepository;

import jakarta.validation.Valid;

@RestController
public class UserJpaResource {

//	@Autowired
//	private UserDaoService service;

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PostRepository postRepository;
	
	// constructor injection
	public UserJpaResource(UserRepository userRepository, PostRepository postRepository) {
//		this.service = service;
		this.userRepository = userRepository;
		this.postRepository=postRepository;
	}

	// method to retrieve all the users
	@GetMapping("/jpa/users")
	public List<User> retrieveAllUsers() {
		return userRepository.findAll();
	}

	// method to retrieve one specific user
	@GetMapping("/jpa/users/{id}")
	public EntityModel<User> retrieveUsers(@PathVariable int id) {
//		return service.findOne(id);
		Optional<User> user = userRepository.findById(id);
		
		if(user.isEmpty()) {
			throw new UserNotFoundException("id:"+id);
		}
		
		EntityModel<User> entityModel = EntityModel.of(user.get());
		
		
		return entityModel;
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
	@PostMapping("/jpa/users")
	public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
		// changed from public User createUser(@RequestBody User user)
		// return service.save(user);
		// service.save(user); // changed to get the location for newly created item
		User savedUser = userRepository.save(user);
		// To get the url for newly created item so that it can be checked from the
		// response body
		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(savedUser.getId())
				.toUri();
		return ResponseEntity.created(location).build();
	}
	
	
	@DeleteMapping("/jpa/users/{id}")
	public void deleteUser(@PathVariable int id) {
//		return service.findOne(id);
		userRepository.deleteById(id);
//		if(user==null) {
//			throw new UserNotFoundException("id:"+id);
//		}
	}
	
	@GetMapping("/jpa/users/{id}/posts")
	public List<Post> retrievePostsForUser(@PathVariable int id) {
		Optional<User> user = userRepository.findById(id);
		
		if(user.isEmpty()) {
			throw new UserNotFoundException("id:" +id);
		}
		
		return user.get().getPosts();

	}
	
	
	//posts creation in jpa
	
	@PostMapping("/jpa/users/{id}/posts")
	public ResponseEntity<Object> createPostForUser(@PathVariable int id,@Valid @RequestBody Post post) {
		Optional<User> user = userRepository.findById(id);
		
		if(user.isEmpty()) {
			throw new UserNotFoundException("id:" +id);
		}
		
		post.setUser(user.get());
		
		Post savedPost = postRepository.save(post);
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(savedPost.getId())
				.toUri();
		
		return ResponseEntity.created(location).build();
	}
	
	
	
	
	
	
	
	
}
