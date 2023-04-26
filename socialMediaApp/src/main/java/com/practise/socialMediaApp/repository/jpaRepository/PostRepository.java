package com.practise.socialMediaApp.repository.jpaRepository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.practise.socialMediaApp.model.Post;


public interface PostRepository extends JpaRepository<Post, Integer > {

}
