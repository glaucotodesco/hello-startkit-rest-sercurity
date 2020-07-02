package com.example.demo.controller;

import com.example.demo.dto.UserLoginDTO;
import com.example.demo.model.UserLogin;
import com.example.demo.service.UserLoginService;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

    @Autowired
    private UserLoginService service;
    
    @Autowired
	private ModelMapper modelMapper;


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

    @PreAuthorize("hasAnyRole('ADMIN')")
    @GetMapping("/privateAdm")
    public String privateAdmContent() {
        return "private Adm Content";
    }

    @GetMapping("/users/{id}")
    public ResponseEntity <UserLoginDTO> getAllUsers(@PathVariable Integer id){
        UserLogin user = service.getUserById(id);
        UserLoginDTO userDTO = modelMapper.map(user, UserLoginDTO.class);    
        return ResponseEntity.ok().body(userDTO);
    }

}