package com.learnJPAandH2.revisionJpaH2.course.jpa;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.learnJPAandH2.revisionJpaH2.course.Course;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class CourseJpaRepository {
//	@Autowired or
	@PersistenceContext
	private EntityManager entityManager; // if we talk to the jpa repository than we need entity manager
	
	public void insert(Course course) {
		entityManager.merge(course);
	}
	
	public Course findById(long id ) {
		return entityManager.find(Course.class, id);
	}
	
	public void deleteById(long id) {
		Course course = entityManager.find(Course.class, id);
		entityManager.remove(course);
	}
}
