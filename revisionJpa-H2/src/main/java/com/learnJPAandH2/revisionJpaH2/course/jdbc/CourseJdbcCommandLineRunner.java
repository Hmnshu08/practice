package com.learnJPAandH2.revisionJpaH2.course.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.learnJPAandH2.revisionJpaH2.course.Course;

@Component
public class CourseJdbcCommandLineRunner implements CommandLineRunner {

	@Autowired
	private CourseJdbcRepository repository;
	
	@Override
	public void run(String... args) throws Exception {
		repository.insert(new Course(1,"Learn AWS","Mahesh"));
		repository.insert(new Course(2,"Learn GCP","Mahesh"));
		repository.insert(new Course(3,"Learn AZURE","Mahesh"));
		repository.deleteById(2);
		System.out.println(repository.findById(3));
		System.out.println(repository.findById(1));
		
	}

}
