package com.helloDemo.helloEx.Controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.helloDemo.helloEx.model.Movies;
import com.helloDemo.helloEx.model.Topic;

@RestController
public class HelloController {

		@RequestMapping("/hello")
		public String sayHello() {
			return "Hello World..!!";
		}
		
		@RequestMapping("/hi")
		public String sayHi() {
			return "Hi World..!!";
		}
		
		
		@RequestMapping("/topic")
		public List<Topic> getAllTopics() {
			return Arrays.asList(
					new Topic(1,"Spring","Spring framework Description"),
					new Topic(1,"AWS","AWS Description"),
					new Topic(1,"GCP","GCP Description")
					);
		}
		
		@RequestMapping("/movies")
		public List<Movies> getAllMovies(){
			return Arrays.asList(
					new Movies (1,"Anything Everything At Once",4.5),
					new Movies (2,"AVP",4),
					new Movies (3,"Aliens",4),
					new Movies (3,"Prometheus",4)
					
					);
		}
}
