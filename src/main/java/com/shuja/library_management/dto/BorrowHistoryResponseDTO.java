package com.shuja.library_management.dto;

import java.util.List;

public class BorrowHistoryResponseDTO {

    private List<BorrowRecordResponseDTO> records;

    private int currentPage;
    private int totalPages;
    private long totalRecords;
    private int pageSize;

    public BorrowHistoryResponseDTO() {
    }

    public BorrowHistoryResponseDTO(
            List<BorrowRecordResponseDTO> records,
            int currentPage,
            int totalPages,
            long totalRecords,
            int pageSize) {

        this.records = records;
        this.currentPage = currentPage;
        this.totalPages = totalPages;
        this.totalRecords = totalRecords;
        this.pageSize = pageSize;
    }

    public List<BorrowRecordResponseDTO> getRecords() {
        return records;
    }

    public void setRecords(List<BorrowRecordResponseDTO> records) {
        this.records = records;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public long getTotalRecords() {
        return totalRecords;
    }

    public void setTotalRecords(long totalRecords) {
        this.totalRecords = totalRecords;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
}