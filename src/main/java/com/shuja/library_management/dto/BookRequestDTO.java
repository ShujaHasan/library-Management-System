package com.shuja.library_management.dto;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;

public class BookRequestDTO {

    @NotBlank(message = "Title is required")
    private String title;

    @NotBlank(message = "ISBN is required")
    private String isbn;

    private Integer publicationYear;

    @Positive(message = "Price must be positive")
    private double price;

    
    @PositiveOrZero(message = "Available copies cannot be negative")
    private int availableCopies;

    @NotNull(message = "Author ID is required")
    private Integer authorId;


    public BookRequestDTO(){}

    public BookRequestDTO(String title, String isbn, Integer publicationYear,
                          double price, int availableCopies, Integer authorId){
        this.title = title;
        this.isbn = isbn;
        this.publicationYear = publicationYear;
        this.price = price;
        this.availableCopies = availableCopies;
        this.authorId = authorId;
    }


}