package com.raj.spring_security_jwt.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.raj.spring_security_jwt.Model.Users;
import com.raj.spring_security_jwt.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/api")
public class SecurityController {

    @Autowired
    UserService userService;

    @PostMapping("/register")
    public void registerUser(@RequestBody Users user) {
        userService.register(user);
    }
    
}
