package com.example.spring_security_jjwt.service;

import com.example.spring_security_jjwt.dto.LoginDto;
import com.example.spring_security_jjwt.dto.RegisterDto;
import com.example.spring_security_jjwt.entity.User;

import java.util.Optional;

public interface UserService {
    Optional<User>register(RegisterDto dto);



String login(LoginDto dto);

Optional<User> findUserById(Long id);




}
