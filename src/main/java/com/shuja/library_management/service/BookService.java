package com.shuja.library_management.service;

import com.shuja.library_management.model.Author;
import com.shuja.library_management.model.Book;
import com.shuja.library_management.model.repository.AuthorRepository;
import com.shuja.library_management.model.repository.BookRepository;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    public BookService(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }


    public Book addBooks(Book books){
        Author author = authorRepository.findById(books.getAuthor().getId())
                .orElseThrow(()-> new RuntimeException("Author ID" + books.getAuthor().getId() + " does not exist!"));

        books.setAuthor(author);
        return bookRepository.save(books);

    }



}
