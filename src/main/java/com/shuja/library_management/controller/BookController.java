package com.shuja.library_management.controller;

import com.shuja.library_management.dto.*;
import com.shuja.library_management.model.repository.BorrowRecordRepository;
import com.shuja.library_management.service.AuthService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import com.shuja.library_management.service.BookService;

import java.util.List;

@RestController
public class BookController {

    private final BookService bookService;
    private final AuthService registrationService;
    private final BorrowRecordRepository borrowRecordRepository;

    public BookController(BookService bookService, AuthService registrationService, BorrowRecordRepository borrowRecordRepository) {
        this.bookService = bookService;
        this.registrationService = registrationService;
        this.borrowRecordRepository = borrowRecordRepository;
    }


    @PostMapping("/books")
    public BookResponseDTO addBook(@Valid @RequestBody BookRequestDTO dto){
        return bookService.addBook(dto);
    }

    @GetMapping("/books")
    public List<BookResponseDTO> getAllBooks(){
        return bookService.getAllBooks();
    }

    @GetMapping("/books/{id}")
    public BookResponseDTO getBookById(@PathVariable Integer id){
        return bookService.getBookById(id);
    }

    @PutMapping("/books/{id}")
    public BookResponseDTO updateBook(@Valid @RequestBody BookRequestDTO dto, @PathVariable Integer id){
        return bookService.updateBook(id ,dto);
    }

//    @DeleteMapping("/books/{id}")
//    public void deleteBook(@PathVariable Integer id) {
//        bookService.deleteBook(id);
//    }





}
