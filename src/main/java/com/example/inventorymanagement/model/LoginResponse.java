package com.example.inventorymanagement.model;

public class LoginResponse {
    private String token;
    private Long userId;

    public LoginResponse(String token, Long userId) {
        this.userId = userId;
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public Long getUserId() {
        return userId;
    }
}