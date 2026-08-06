package com.shuja.library_management.dto;

import com.shuja.library_management.model.Book;

public class BorrowBookRequestDTO {
    private Integer bookID;
    private Integer memberID;

    public BorrowBookRequestDTO(){}

    public BorrowBookRequestDTO(Integer bookID, Integer memberID){
        this.bookID = bookID;
        this.memberID = memberID;
    }

    public Integer getBookID() {
        return bookID;
    }

    public Integer getMemberID() {
        return memberID;
    }

    public void setBookID(Integer bookID) {
        this.bookID = bookID;
    }

    public void setMemberID(Integer memberID) {
        this.memberID = memberID;
    }
}
