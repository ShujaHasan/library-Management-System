package com.shuja.library_management.service;

import com.shuja.library_management.dto.DashboardResponseDTO;
import com.shuja.library_management.model.BorrowStatus;
import com.shuja.library_management.model.repository.AuthorRepository;
import com.shuja.library_management.model.repository.BookRepository;
import com.shuja.library_management.model.repository.BorrowRecordRepository;
import com.shuja.library_management.model.repository.MemberRepository;
import org.springframework.stereotype.Service;

@Service
public class DashboardService {
    private final BookRepository bookRepository;
    private final MemberRepository memberRepository;
    private final BorrowRecordRepository borrowRecordRepository;
    private final AuthorRepository authorRepository;

    public DashboardService(BookRepository bookRepository, MemberRepository memberRepository, BorrowRecordRepository borrowRecordRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.memberRepository = memberRepository;
        this.borrowRecordRepository = borrowRecordRepository;
        this.authorRepository = authorRepository;
    }

    public DashboardResponseDTO getDashboard(){
        long totalBooks = bookRepository.count();

        long totalMembers = memberRepository.count();

        long totalAuthors = authorRepository.count();

        long totalAvailableCopies = bookRepository.getTotalAvailableCopies();

        long activeBorrowings = borrowRecordRepository.countByStatus(BorrowStatus.BORROWED);

        long overdueBorrowings = borrowRecordRepository.countByStatus(BorrowStatus.OVERDUE);

        return new DashboardResponseDTO(
                totalBooks,
                totalMembers,
                totalAuthors,
                totalAvailableCopies,
                activeBorrowings,
                overdueBorrowings
        );

    }




}
