package com.restPractise.restfulwebservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
	
	//printing hello world
	@GetMapping("/hello")
	public String helloWorld() {	//method returning string
		return "Hello World!!!..";
	}
	
	//method for json response
	@GetMapping("/hello-bean")
	public HelloWorldBean helloWorldBean () {
		return new HelloWorldBean("Hello World!!!..");
	}
	
	//path variable- adding a variable in the rest url
		@GetMapping("/hello-bean-{name}")
		public HelloWorldBean helloWorldBeanPathVariable (@PathVariable String name) {
			return new HelloWorldBean(String.format("Hello World!!!.., %s", name));
		}
}