package com.shuja.library_management.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class MemberRequestDTO {
    @NotBlank(message = "Name cannot be empty")
    private String fullName;

    @Email(message = "Enter valid email address")
    @NotBlank(message = "Email cannot be empty")
    private String email;

    @NotBlank(message = "Phone Number cannot be empty!")
    private String phone;

    private String address;

}
