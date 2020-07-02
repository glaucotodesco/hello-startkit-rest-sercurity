package com.example.demo.service;

import java.util.Arrays;

import com.example.demo.model.UserLogin;
import com.example.demo.model.UserProfile;
import com.example.demo.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class DBServiceTestProfile {

    @Autowired
    private UserRepository repo;

    @Autowired
    private BCryptPasswordEncoder encoder;

    public void initTestDataBase() {

        UserLogin user = new UserLogin("usr", encoder.encode("123"));
        user.getProfiles().add(UserProfile.USER);

        UserLogin userAdm = new UserLogin("adm", encoder.encode("123"));
        userAdm.getProfiles().add(UserProfile.USER);
        userAdm.getProfiles().add(UserProfile.ADMIN);

        repo.saveAll(Arrays.asList(user, userAdm));

    }

}