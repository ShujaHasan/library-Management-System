package com.shuja.library_management.dto;

public class FineResponseDTO {

    private Integer borrowRecordId;
    private String memberName;
    private String bookTitle;
    private long lateDays;
    private double fineAmount;
    private String message;

    public FineResponseDTO() {
    }

    public FineResponseDTO(Integer borrowRecordId,
                           String memberName,
                           String bookTitle,
                           long lateDays,
                           double fineAmount,
                           String message) {
        this.borrowRecordId = borrowRecordId;
        this.memberName = memberName;
        this.bookTitle = bookTitle;
        this.lateDays = lateDays;
        this.fineAmount = fineAmount;
        this.message = message;
    }

    public Integer getBorrowRecordId() {
        return borrowRecordId;
    }

    public void setBorrowRecordId(Integer borrowRecordId) {
        this.borrowRecordId = borrowRecordId;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public long getLateDays() {
        return lateDays;
    }

    public void setLateDays(long lateDays) {
        this.lateDays = lateDays;
    }

    public double getFineAmount() {
        return fineAmount;
    }

    public void setFineAmount(double fineAmount) {
        this.fineAmount = fineAmount;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}