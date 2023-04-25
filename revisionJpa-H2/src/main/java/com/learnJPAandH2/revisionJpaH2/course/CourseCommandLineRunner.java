package com.learnJPAandH2.revisionJpaH2.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

//import com.learnJPAandH2.revisionJpaH2.course.jdbc.CourseJdbcRepository;
import com.learnJPAandH2.revisionJpaH2.course.jpa.CourseJpaRepository;

@Component
public class CourseCommandLineRunner implements CommandLineRunner {

//	@Autowired
//	private CourseJdbcRepository repository;
	
	@Autowired
	private CourseJpaRepository repository;
	
	@Override
	public void run(String... args) throws Exception {
		repository.insert(new Course(1,"Learn AWS Now","Mahesh"));
		repository.insert(new Course(2,"Learn GCP Tomorrow","Mahesh"));
		repository.insert(new Course(3,"Learn AZURE Day after tomorrow","Mahesh"));
		repository.deleteById(2);
		System.out.println(repository.findById(3));
		System.out.println(repository.findById(1));
		
	}

}
