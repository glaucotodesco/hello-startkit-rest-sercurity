package com.example.demo.config;

import com.example.demo.service.DBServiceTestProfile;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("test")
public class TestProfileConfig {
    
    @Autowired
    private DBServiceTestProfile service;

    @Bean
    public void createTestDatabase()
    {
        System.out.println("Create Test Database");
        service.initTestDataBase();
    }
}