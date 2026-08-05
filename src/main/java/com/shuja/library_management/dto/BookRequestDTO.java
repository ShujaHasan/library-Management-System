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

    public String getTitle() {
        return title;
    }

    public String getIsbn() {
        return isbn;
    }

    public int getAvailableCopies() {
        return availableCopies;
    }

    public double getPrice() {
        return price;
    }

    public Integer getAuthorId() {
        return authorId;
    }

    public Integer getPublicationYear() {
        return publicationYear;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPublicationYear(Integer publicationYear) {
        this.publicationYear = publicationYear;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setAvailableCopies(int availableCopies) {
        this.availableCopies = availableCopies;
    }

    public void setAuthorId(Integer authorId) {
        this.authorId = authorId;
    }
}