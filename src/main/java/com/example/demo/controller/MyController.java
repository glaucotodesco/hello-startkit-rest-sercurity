package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

    @GetMapping("/public")
    public String publicContent() {
        return "Public GET Content";
    }

    @PostMapping("/public")
    public String publicPostContent() {
        return "Public Post Content";
    }

    @GetMapping("/private")
    public String privateContent() {
        return "private Content";
    }

    @GetMapping("/privateAdm")
    public String privateAdmContent() {
        return "private Adm Content";
    }

}