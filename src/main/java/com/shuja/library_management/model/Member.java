package com.shuja.library_management.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.util.List;

@Entity
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "Name cannot be empty")
    private String fullName;

    @Email(message = "Enter valid email address")
    @NotBlank(message = "Email cannot be empty")
    @Column(nullable = false, unique = true)
    private String email;

    @NotBlank(message = "Phone Number cannot be empty!")
    @Column(nullable = false)
    private String phone;

    @NotBlank(message = "Address cannot be empty")
    @Column(nullable = false)
    private String address;

    @Column(nullable = false)
    private LocalDate membershipDate;

    @OneToMany(mappedBy = "member")
    private List<BorrowRecord> borrowRecords;


    public Member(){}

    public Member(String fullName, String email, String phone, String address, LocalDate membershipDate){
        this.fullName = fullName;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.membershipDate = membershipDate;
    }

    public Integer getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    public String getFullName() {
        return fullName;
    }

    public LocalDate getMembershipDate() {
        return membershipDate;
    }

    public String getPhone() {
        return phone;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setMembershipDate(LocalDate membershipDate) {
        this.membershipDate = membershipDate;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
