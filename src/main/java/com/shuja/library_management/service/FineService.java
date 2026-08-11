package com.shuja.library_management.service;

import com.shuja.library_management.dto.FineResponseDTO;
import com.shuja.library_management.model.BorrowRecord;
import com.shuja.library_management.model.BorrowStatus;
import com.shuja.library_management.model.repository.BorrowRecordRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

@Service
public class FineService {

    private static final double FINE_PER_DAY = 20;

    private final BorrowRecordRepository borrowRecordRepository;

    public FineService(BorrowRecordRepository borrowRecordRepository) {
        this.borrowRecordRepository = borrowRecordRepository;
    }

    public FineResponseDTO calculateFine(Integer borrowRecordId){
        BorrowRecord record = borrowRecordRepository.findById(borrowRecordId)
                .orElseThrow(()-> new RuntimeException("Book record not found"));

        LocalDate endDate;

        if(record.getReturnDate() != null){
            endDate = record.getReturnDate().toLocalDate();
        }
        else {
            endDate = LocalDate.now();
        }

        long lateDays = 0;

        if (endDate.isAfter(record.getDueDate())){
            lateDays = ChronoUnit.DAYS.between(record.getDueDate(), endDate);
        }

        double fineAmount = lateDays * FINE_PER_DAY;

        String message;
        if (fineAmount > 0){
            message = "Fine calculated successfully!";
        }
        else {
            message = "No fine, book was returned on time!";
        }

        return new FineResponseDTO(
                record.getId(),
                record.getMember().getFullName(),
                record.getBook().getTitle(),
                lateDays, fineAmount, message
        );
    }
}
