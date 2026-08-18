package com.shuja.library_management.controller;

import com.shuja.library_management.dto.DashboardResponseDTO;
import com.shuja.library_management.service.DashboardService;
import org.springframework.web.bind.annotation.*;

@RestController
public class DashboardController {

    private final DashboardService dashboardService;

    public DashboardController(
            DashboardService dashboardService) {
        this.dashboardService = dashboardService;
    }

    @GetMapping("/dashboard")
    public DashboardResponseDTO getDashboard() {
        return dashboardService.getDashboard();
    }
}