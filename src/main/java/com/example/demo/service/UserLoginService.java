package com.example.demo.service;

import com.example.demo.model.UserLogin;
import com.example.demo.model.UserProfile;
import com.example.demo.repository.UserRepository;
import com.example.demo.security.UserSS;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserLoginService {

    @Autowired
    private UserRepository repo;

    public UserLogin getUserById(Integer id) {
        UserSS userSS = UserSSService.getAuthenticated();

        if (userSS == null || !userSS.hasRole(UserProfile.ADMIN) && !id.equals(userSS.getId())) {
            throw new RuntimeException("Acesso negado");
        } else {
           return repo.findById(id).get();
        }
    }

}