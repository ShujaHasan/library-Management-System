package com.shuja.library_management.model.repository;

import com.shuja.library_management.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByUsername(String Username);

    boolean existsByUsername(String username);
}
