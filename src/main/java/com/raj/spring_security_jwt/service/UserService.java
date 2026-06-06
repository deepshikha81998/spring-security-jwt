package com.raj.spring_security_jwt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.raj.spring_security_jwt.Model.Users;
import com.raj.spring_security_jwt.repo.UserRepo;

@Service
public class UserService implements UserDetailsService {
    @Autowired
    private UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users userInfo = userRepo.findById(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not Found for " + username));

        return User
                .withUsername(userInfo.getUsername())
                .password(userInfo.getPassword())
                .roles(userInfo.getRole())
                .build();
    }

    @Autowired
    PasswordEncoder passwordEncoder;

    public String register(Users users) {
        users.setPassword(passwordEncoder.encode(users.getPassword()));
        userRepo.save(users);
        return "User registered successfully!";
    }
}
