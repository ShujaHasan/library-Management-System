package com.shuja.library_management.model.repository;

import com.shuja.library_management.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BookRepository extends JpaRepository<Book, Integer> {
    @Query("""
    SELECT COALESCE(SUM(b.availableCopies), 0)
    FROM Book b
""")
    long getTotalAvailableCopies();
}
