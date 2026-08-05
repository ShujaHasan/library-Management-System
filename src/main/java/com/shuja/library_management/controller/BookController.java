package com.shuja.library_management.controller;

import com.shuja.library_management.dto.*;
import com.shuja.library_management.service.AuthService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import com.shuja.library_management.service.BookService;

import java.util.List;

@RestController
public class BookController {

    private final BookService bookService;
    private final AuthService registrationService;

    public BookController(BookService bookService, AuthService registrationService) {
        this.bookService = bookService;
        this.registrationService = registrationService;
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





}
