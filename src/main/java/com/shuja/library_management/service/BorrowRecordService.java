package com.shuja.library_management.service;

import com.shuja.library_management.dto.*;
import com.shuja.library_management.exception.BookAlreadyBorrowedException;
import com.shuja.library_management.exception.BookNotFoundException;
import com.shuja.library_management.exception.BookUnavailableException;
import com.shuja.library_management.exception.MemberNotFoundException;
import com.shuja.library_management.model.Book;
import com.shuja.library_management.model.BorrowRecord;
import com.shuja.library_management.model.BorrowStatus;
import com.shuja.library_management.model.Member;
import com.shuja.library_management.model.repository.BookRepository;
import com.shuja.library_management.model.repository.BorrowRecordRepository;
import com.shuja.library_management.model.repository.MemberRepository;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class BorrowRecordService {
    private final BorrowRecordRepository borrowRecordRepository;
    private final MemberRepository memberRepository;
    private final BookRepository bookRepository;

    public BorrowRecordService(MemberRepository memberRepository, BorrowRecordRepository borrowRecordRepository, BookRepository bookRepository) {
        this.borrowRecordRepository = borrowRecordRepository;
        this.bookRepository = bookRepository;
        this.memberRepository = memberRepository;
    }

    @Transactional
    public BorrowRecordResponseDTO borrowBook(BorrowBookRequestDTO dto){

        Member member = memberRepository.findById(dto.getMemberID())
                .orElseThrow(()-> new MemberNotFoundException("member not found"));

        Book book = bookRepository.findById(dto.getBookID())
                .orElseThrow(() -> new BookNotFoundException("Book not found"));

        if (book.getAvailableCopies() <= 0){
            throw new BookUnavailableException("Book is unavailable");
        }

        boolean alreadyBorrowed = borrowRecordRepository.existsByMemberAndBookAndStatus(
                member,
                book,
                BorrowStatus.BORROWED
                );

        if (alreadyBorrowed) {
            throw new BookAlreadyBorrowedException(
                    "Member has already borrowed this book."
            );
        }

        BorrowRecord record = new BorrowRecord();

        record.setMember(member);

        record.setBook(book);

        record.setBorrowDate(LocalDateTime.now());

        record.setDueDate(LocalDate.now().plusDays(14));

        record.setStatus(BorrowStatus.BORROWED);

        book.setAvailableCopies(book.getAvailableCopies() - 1);

        bookRepository.save(book);

        BorrowRecord savedRecord = borrowRecordRepository.save(record);

        return convertToDTO(savedRecord);

    }

    public BorrowRecordResponseDTO convertToDTO(BorrowRecord record){
        return new BorrowRecordResponseDTO(
                record.getId(),
                record.getMember().getFullName(),
                record.getBook().getTitle(),
                record.getBorrowDate(),
                record.getDueDate(),
                record.getReturnDate(),
                record.getStatus().name()
        );
    }

    @Transactional
    public ReturnBookResponseDTO returnBook(ReturnBookRequestDTO dto){

        BorrowRecord record = borrowRecordRepository.findByMemberIdAndBookIdAndStatus(dto.getMemberID(), dto.getBookID(), BorrowStatus.BORROWED)
                .orElseThrow(()-> new RuntimeException("No active borrow record found"));

        record.setStatus(BorrowStatus.RETURNED);

        record.setReturnDate(LocalDateTime.now());

        Book book = record.getBook();
        book.setAvailableCopies(book.getAvailableCopies() + 1);

        bookRepository.save(book);
        BorrowRecord savedRecord = borrowRecordRepository.save(record);

        return convertToResponseDTO(savedRecord,"Book successfully processed and checked back into the library system.");

    }

    private ReturnBookResponseDTO convertToResponseDTO(BorrowRecord record, String message){
        return new ReturnBookResponseDTO(
                message,
                record.getBook().getId(),
                record.getMember().getId(),
                record.getStatus().name()
        );
    }

    public BorrowHistoryResponseDTO getMemberHistory(Integer memberId, int page, int size){
        memberRepository.findById(memberId)
                .orElseThrow(()-> new RuntimeException("Member not found!"));

        Pageable pageable = PageRequest.of(page, size);

        Page<BorrowRecord> record = borrowRecordRepository.findByBookId(memberId, pageable);

        return convertToHistoryResponse(record);
    }

    public BorrowHistoryResponseDTO getBookHistory(Integer bookId, int page, int size){
        bookRepository.findById(bookId)
                .orElseThrow(()-> new RuntimeException("Book not found"));

        Pageable pageable = PageRequest.of(page, size);

        Page<BorrowRecord> records = borrowRecordRepository.findByBookId(bookId, pageable);

        return convertToHistoryResponse(records);


    }

    private BorrowHistoryResponseDTO convertToHistoryResponse(
            Page<BorrowRecord> page) {

        List<BorrowRecordResponseDTO> records =
                page.getContent()
                        .stream()
                        .map(this::convertToDTO)
                        .toList();

        return new BorrowHistoryResponseDTO(
                records,
                page.getNumber(),
                page.getTotalPages(),
                page.getTotalElements(),
                page.getSize()
        );
    }

}
