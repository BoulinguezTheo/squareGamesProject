package com.example.squaregamesspring.dto;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;

public class UserDto {
    @Id
    @GeneratedValue
    private int id;
    private String username;
    private String password;
    private List<String> authorities;
//    private boolean admin;

    public UserDto() {
    }

    public UserDto(UserDetails userDetails) {
        this.username = userDetails.getUsername();
        this.password = userDetails.getPassword();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<String> getAuthorities() {
        return null;
    }

//    public boolean isAdmin() {
//        return admin;
//    }
//
//    public void setAdmin(boolean admin) {
//        this.admin = admin;
//    }
}
