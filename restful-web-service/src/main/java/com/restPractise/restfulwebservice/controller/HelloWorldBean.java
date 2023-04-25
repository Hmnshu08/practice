package com.restPractise.restfulwebservice.controller;

public class HelloWorldBean {
	private String word;

	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}

	@Override
	public String toString() {
		return "HelloWorldBean [word=" + word + "]";
	}

	public HelloWorldBean(String word) {
		super();
		this.word = word;
	}
	
	
}
