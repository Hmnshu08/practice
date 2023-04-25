package com.learnJPAandH2.revisionJpaH2.course.springDataJpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learnJPAandH2.revisionJpaH2.course.Course;

public interface CourseSpringDataJpaRepository extends JpaRepository <Course, Long> //what entity it manages , and what is Id field
{
	// can have custom querys also
	List<Course> findByAuthor (String author);
	
}
