package com.example.demo.service;

import com.example.demo.security.UserSS;

import org.springframework.security.core.context.SecurityContextHolder;

public class UserSSService {

    public static UserSS getAuthenticated() {
        try {
            return (UserSS) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        } catch (Exception e) {
            return null;
        }
    }
    
}