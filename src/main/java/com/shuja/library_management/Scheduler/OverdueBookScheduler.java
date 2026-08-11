package com.shuja.library_management.Scheduler;

import com.shuja.library_management.model.BorrowRecord;
import com.shuja.library_management.model.BorrowStatus;
import com.shuja.library_management.model.repository.BorrowRecordRepository;
import jakarta.transaction.Transactional;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
public class OverdueBookScheduler {
    private final BorrowRecordRepository borrowRecordRepository;

    public OverdueBookScheduler(BorrowRecordRepository borrowRecordRepository) {
        this.borrowRecordRepository = borrowRecordRepository;
    }

    @Scheduled(cron = "0 0 0 * * *")
    @Transactional
    public void markOverdueBooks(){
        List<BorrowRecord> records = borrowRecordRepository.findByStatus(BorrowStatus.BORROWED);

        LocalDate today = LocalDate.now();

        for (BorrowRecord record : records){

            if (record.getDueDate().isBefore(today)){
                record.setStatus(BorrowStatus.OVERDUE);
            }
        }
        borrowRecordRepository.saveAll(records);
    }
}
