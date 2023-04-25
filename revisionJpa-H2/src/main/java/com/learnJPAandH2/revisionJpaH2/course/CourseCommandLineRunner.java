package com.learnJPAandH2.revisionJpaH2.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

//import com.learnJPAandH2.revisionJpaH2.course.jdbc.CourseJdbcRepository;
import com.learnJPAandH2.revisionJpaH2.course.jpa.CourseJpaRepository;
import com.learnJPAandH2.revisionJpaH2.course.springDataJpa.CourseSpringDataJpaRepository;

@Component
public class CourseCommandLineRunner implements CommandLineRunner {

//	@Autowired
//	private CourseJdbcRepository repository;
	
//	@Autowired
//	private CourseJpaRepository repository;
	
	@Autowired
	private CourseSpringDataJpaRepository repository;
	
	@Override
	public void run(String... args) throws Exception {
		repository.save(new Course(1,"Learn AWS Now","Mahesh"));
		repository.save(new Course(2,"Learn GCP Tomorrow","Mahesh"));
		repository.save(new Course(3,"Learn AZURE Day after tomorrow","Mahesh"));
		repository.deleteById(2l);// needs 'l' at the end of the id
		System.out.println(repository.findById(3l));
		System.out.println(repository.findById(1l));
		
		System.out.println(repository.findAll());
		System.out.println("-------------------------");
		System.out.println(repository.findByAuthor("Mahesh"));
		
	}

}
