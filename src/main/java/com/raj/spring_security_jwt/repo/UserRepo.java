package com.raj.spring_security_jwt.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.raj.spring_security_jwt.Model.Users;

public interface UserRepo extends JpaRepository<Users,String>{
}
