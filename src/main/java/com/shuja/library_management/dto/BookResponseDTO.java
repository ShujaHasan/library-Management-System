package com.shuja.library_management.dto;

public class BookResponseDTO {

        private int id;
        private String title;
        private String isbn;
        private String authorName;

        public BookResponseDTO() {
        }

        public BookResponseDTO(int id, String title, String isbn, String authorName) {
            this.id = id;
            this.title = title;
            this.isbn = isbn;
            this.authorName = authorName;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getIsbn() {
            return isbn;
        }

        public void setIsbn(String isbn) {
            this.isbn = isbn;
        }

        public String getAuthorName() {
            return authorName;
        }

        public void setAuthorName(String authorName) {
            this.authorName = authorName;
        }
    }
