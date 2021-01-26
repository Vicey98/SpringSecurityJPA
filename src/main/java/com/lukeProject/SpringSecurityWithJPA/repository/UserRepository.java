package com.lukeProject.SpringSecurityWithJPA.repository;

import java.util.Optional;

import com.lukeProject.SpringSecurityWithJPA.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
    
    Optional<User> findByUserName(String username);
    
}
