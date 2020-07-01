package com.example.demo.security;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

import com.example.demo.model.UserProfile;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class UserSS implements UserDetails {
    private static final long serialVersionUID = 1L;

    private Integer id;
    private String username;
    private String password;
    private Collection <? extends GrantedAuthority> authorities;

    public UserSS(int id, String username, String password, Set<UserProfile> profiles) {
        this.id = id;
        this.username = username;
        this.password = password;
        
        profiles.stream().
                map( p -> new SimpleGrantedAuthority(p.getRole())).
                collect(Collectors.toList());
	}

	@Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    public Integer getId(){
        return  id;
    }

    @Override
    public String getPassword() {
    
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
    
}