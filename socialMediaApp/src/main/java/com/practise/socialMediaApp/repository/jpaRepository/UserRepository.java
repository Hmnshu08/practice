package com.practise.socialMediaApp.repository.jpaRepository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.practise.socialMediaApp.model.User;

public interface UserRepository extends JpaRepository<User, Integer > {

}
