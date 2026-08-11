package com.shuja.library_management.controller;

import com.shuja.library_management.dto.FineResponseDTO;
import com.shuja.library_management.service.FineService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FineController {
    private final FineService fineService;

    public FineController(FineService fineService) {
        this.fineService = fineService;
    }

    @GetMapping("/fines{borrowRecordId}")
    public FineResponseDTO calculateFine(@PathVariable Integer borrowRecordId){
        return fineService.calculateFine(borrowRecordId);
    }

}
