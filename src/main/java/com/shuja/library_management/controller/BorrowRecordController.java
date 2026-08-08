package com.shuja.library_management.controller;

import com.shuja.library_management.dto.BorrowBookRequestDTO;
import com.shuja.library_management.dto.BorrowRecordResponseDTO;
import com.shuja.library_management.dto.ReturnBookRequestDTO;
import com.shuja.library_management.dto.ReturnBookResponseDTO;
import com.shuja.library_management.service.BorrowRecordService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BorrowRecordController {

    private final BorrowRecordService borrowRecordService;

    public BorrowRecordController(BorrowRecordService borrowRecordService) {
        this.borrowRecordService = borrowRecordService;
    }

    @PostMapping("/borrow")
    public BorrowRecordResponseDTO borrowBook(@Valid @RequestBody BorrowBookRequestDTO dto){
        return borrowRecordService.borrowBook(dto);
    }

    @PostMapping("/return")
    public ReturnBookResponseDTO returnBook(@RequestBody ReturnBookRequestDTO dto){
        return borrowRecordService.returnBook(dto);
    }
}
