package com.shuja.library_management.controller;

import com.shuja.library_management.model.Book;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.shuja.library_management.service.BookService;

@RestController
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }


    @PostMapping("/books")
    public Book addBooks(@Valid @RequestBody Book books){
        return BookService.addBooks(books);
    }
}
