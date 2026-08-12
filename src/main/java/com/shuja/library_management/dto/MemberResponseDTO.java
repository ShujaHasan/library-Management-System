package com.shuja.library_management.dto;

import java.time.LocalDate;

public class MemberResponseDTO {

    private Integer id;
    private String fullName;
    private String email;
    private String phone;
    private String address;
    private LocalDate membershipDate;

    public MemberResponseDTO() {
    }

    public MemberResponseDTO(Integer id,
                             String fullName,
                             String email,
                             String phone,
                             String address,
                             LocalDate membershipDate) {
        this.id = id;
        this.fullName = fullName;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.membershipDate = membershipDate;
    }

    public MemberResponseDTO(Integer id, String fullName, String email, String email1, String phone, String address, LocalDate membershipDate) {
    }

    // getters and setters


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public LocalDate getMembershipDate() {
        return membershipDate;
    }

    public void setMembershipDate(LocalDate membershipDate) {
        this.membershipDate = membershipDate;
    }
}