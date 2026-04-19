package com.example.auth_service.repository;

import com.example.auth_service.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Long> {
    
}
