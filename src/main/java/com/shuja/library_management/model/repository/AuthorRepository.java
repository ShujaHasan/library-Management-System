package com.shuja.library_management.model.repository;

import com.shuja.library_management.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Integer> {
    boolean existsByEmail(String email);

}
