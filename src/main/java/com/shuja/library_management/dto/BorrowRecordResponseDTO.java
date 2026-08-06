package com.shuja.library_management.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class BorrowRecordResponseDTO {

    private Integer id;
    private String memberName;
    private String bookTitle;
    private LocalDateTime borrowDate;
    private LocalDate dueDate;
    private LocalDateTime returnDate;
    private String status;

    public BorrowRecordResponseDTO() {
    }

    public BorrowRecordResponseDTO
            (Integer id, String memberName, String bookTitle,
             LocalDateTime borrowDate, LocalDate dueDate,
             LocalDateTime returnDate, String status) {

        this.id = id;
        this.memberName = memberName;
        this.bookTitle = bookTitle;
        this.borrowDate = borrowDate;
        this.dueDate = dueDate;
        this.returnDate = returnDate;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public String getMemberName() {
        return memberName;
    }

    public LocalDateTime getBorrowDate() {
        return borrowDate;
    }

    public LocalDateTime getReturnDate() {
        return returnDate;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public String getStatus() {
        return status;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public void setBorrowDate(LocalDateTime borrowDate) {
        this.borrowDate = borrowDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public void setReturnDate(LocalDateTime returnDate) {
        this.returnDate = returnDate;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}