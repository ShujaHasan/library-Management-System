package com.shuja.library_management.dto;

import java.time.LocalDate;

public class ReturnBookResponseDTO {
    private String message;
    private Integer bookID;
    private Integer memberID;
    private String finalStatus; // Will be "RETURNED"

    public ReturnBookResponseDTO(String message, Integer bookID, Integer memberID, String finalStatus) {
        this.message = message;
        this.bookID = bookID;
        this.memberID = memberID;
        this.finalStatus = finalStatus;
    }

    // Getters only (Response DTOs are usually read-only data carriers)
    public String getMessage() { return message; }
    public Integer getBookID() { return bookID; }
    public Integer getMemberID() { return memberID; }
    public String getFinalStatus() { return finalStatus; }
}
