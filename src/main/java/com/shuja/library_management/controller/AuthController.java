package com.shuja.library_management.controller;

import com.shuja.library_management.dto.LoginRequestDTO;
import com.shuja.library_management.dto.LoginResponseDTO;
import com.shuja.library_management.dto.RegisterRequestDTO;
import com.shuja.library_management.dto.UserResponseDTO;
import com.shuja.library_management.service.AuthService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")

public class AuthController {
    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/register")
    public UserResponseDTO register(@RequestBody @Valid RegisterRequestDTO dto){
        return authService.register(dto);
    }

    @PostMapping("/login")
    public LoginResponseDTO login(@RequestBody @Valid LoginRequestDTO dto){
        return authService.login(dto);
    }


}
