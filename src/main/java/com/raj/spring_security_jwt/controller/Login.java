package com.raj.spring_security_jwt.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
@RequestMapping("/api")
public class Login {

    @GetMapping("/user")
    public String getUserResponseString() {
        return new String("User Content. Logged in successfully");
    }

    @GetMapping("/admin")
    public String getAdminResponseString() {
        return new String("Admin Content. Logged in successfully");
    }
    
}

