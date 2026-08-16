package com.shuja.library_management.controller;

import com.shuja.library_management.dto.*;
import com.shuja.library_management.service.BorrowRecordService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/borrow/return")
    public ReturnBookResponseDTO returnBook(@RequestBody ReturnBookRequestDTO dto){
        return borrowRecordService.returnBook(dto);
    }

    @GetMapping("/member/{memberID}")
    public BorrowHistoryResponseDTO getMemberHistory(
            @PathVariable Integer memberId,

            @RequestParam(defaultValue = "0")
            int page,

            @RequestParam(defaultValue = "10")
            int size){

        return borrowRecordService.getMemberHistory(memberId, page, size);
    }

    @GetMapping("/book/{bookId}")
    public BorrowHistoryResponseDTO getBookHistory(
            @PathVariable Integer bookId,

            @RequestParam(defaultValue = "0")
            int page,

            @RequestParam(defaultValue = "10")
            int size
            ){

        return borrowRecordService.getBookHistory(bookId, page, size);

    }

}
