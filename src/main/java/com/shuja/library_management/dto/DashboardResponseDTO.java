package com.shuja.library_management.dto;

public class DashboardResponseDTO {

    private long totalBooks;
    private long totalMembers;
    private long totalAuthors;

    private long totalAvailableCopies;

    private long activeBorrowings;
    private long overdueBorrowings;

    public DashboardResponseDTO() {
    }

    public DashboardResponseDTO(
            long totalBooks,
            long totalMembers,
            long totalAuthors,
            long totalAvailableCopies,
            long activeBorrowings,
            long overdueBorrowings) {

        this.totalBooks = totalBooks;
        this.totalMembers = totalMembers;
        this.totalAuthors = totalAuthors;
        this.totalAvailableCopies = totalAvailableCopies;
        this.activeBorrowings = activeBorrowings;
        this.overdueBorrowings = overdueBorrowings;
    }

    public long getTotalBooks() {
        return totalBooks;
    }

    public long getTotalMembers() {
        return totalMembers;
    }

    public long getTotalAuthors() {
        return totalAuthors;
    }

    public long getTotalAvailableCopies() {
        return totalAvailableCopies;
    }

    public long getActiveBorrowings() {
        return activeBorrowings;
    }

    public long getOverdueBorrowings() {
        return overdueBorrowings;
    }
}