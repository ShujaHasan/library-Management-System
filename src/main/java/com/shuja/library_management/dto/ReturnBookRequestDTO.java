package com.shuja.library_management.dto;

public class ReturnBookRequestDTO {
    private Integer bookID;
    private Integer memberID;

    public ReturnBookRequestDTO() {}

    public ReturnBookRequestDTO(Integer bookID, Integer memberID) {
        this.bookID = bookID;
        this.memberID = memberID;
    }

    public Integer getBookID() {
        return bookID;
    }
    public void setBookID(Integer bookID) {
        this.bookID = bookID;
    }

    public Integer getMemberID() {
        return memberID;
    }

    public void setMemberID(Integer memberID) {
        this.memberID = memberID;
    }
}
