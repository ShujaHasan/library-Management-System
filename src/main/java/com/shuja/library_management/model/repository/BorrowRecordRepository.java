package com.shuja.library_management.model.repository;

import com.shuja.library_management.model.Book;
import com.shuja.library_management.model.BorrowRecord;
import com.shuja.library_management.model.BorrowStatus;
import com.shuja.library_management.model.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface BorrowRecordRepository extends JpaRepository<BorrowRecord, Integer> {
    boolean existsByMemberAndBookAndStatus(
            Member member,
            Book book,
            BorrowStatus status
    );

    Optional<BorrowRecord> findByMemberIdAndBookIdAndStatus(
            Integer memberId,
            Integer bookId,
            BorrowStatus status
    );

    List<BorrowRecord> findByStatus(BorrowStatus status);


}
