package com.example.demo.service;

import com.example.demo.model.UserLogin;
import com.example.demo.repository.UserRepository;
import com.example.demo.security.UserSS;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImp implements UserDetailsService {

    @Autowired
    private UserRepository repo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserLogin user = repo.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException(username);
        } 
        else {
            UserSS userSS = new UserSS(user.getId(), user.getUsername(), user.getPassword(), user.getProfiles());
            return userSS;
        }

    }

}