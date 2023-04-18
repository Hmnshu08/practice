package com.helloDemo.helloEx.model;

public class Movies {

	/*Generally, in any OOP-Supported language, the encapsulation is used to prevent the 
	 * alteration of code (data) accidentally from the outside functions. By defining the
	 *  class members' private, we can protect the data from accidental corruption.
	 *  The following are the benefits of encapsulation:
	 *  Protection of data from accidental corruption
	 *  Specification of the accessibility of each of the members of a class to the code 
	 	outside the class
	 *  Flexibility and extensibility of the code and reduction in complexity
	 *  Lower coupling between objects and hence improvement in code maintainability

*/
	private long id;
	private String name;
	private double rating;
	
	public Movies() {
		
	}
	
	public Movies(long id, String name, double d) {
		super();
		this.id = id;
		this.name = name;
		this.rating = d;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(long rating) {
		this.rating = rating;
	}

	@Override
	public String toString() {
		return "Movies [id=" + id + ", name=" + name + ", rating=" + rating + "]";
	}
	
	
	
}
