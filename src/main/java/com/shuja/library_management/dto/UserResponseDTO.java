package com.shuja.library_management.dto;

public class UserResponseDTO {

    private Integer id;
    private String username;
    private String role;

    public UserResponseDTO() {
    }

    public UserResponseDTO(Integer id, String username, String role){
        this.id = id;
        this.username = username;
        this.role = role;
    }

    public Integer getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getRole() {
        return role;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
