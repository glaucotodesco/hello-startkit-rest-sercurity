package com.example.demo.model;

public enum UserProfile {

    USER(1,"ROLE_USER"),
    ADM(2, "ROLE_ADM");

    private int code;
    private String role;

    private UserProfile(int code, String role) {
        this.code = code;
        this.role = role;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    
    
}