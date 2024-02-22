package com.example.spring_security_jjwt.controller;
import com.example.spring_security_jjwt.dto.LoginDto;
import com.example.spring_security_jjwt.dto.RegisterDto;
import com.example.spring_security_jjwt.entity.User;
import com.example.spring_security_jjwt.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.*;
@RestController
@RequiredArgsConstructor
@CrossOrigin
public class AuthController {
    private final UserService service;
    @PostMapping("/register")
    public HttpEntity<?> register(@RequestBody RegisterDto registerDto) {
        Optional<User> register = service.register(registerDto);
        register.orElseThrow(() -> new UsernameNotFoundException("User not found" + registerDto.username()));
        return ResponseEntity.ok(register.get());
    }
    @PostMapping("/loginA")
    public HttpEntity<?> generate(@RequestBody LoginDto dto) {
       return ResponseEntity.ok(service.login(dto));
    }


    @GetMapping("/openForAll")
    public HttpEntity<?>openApi(){
        return ResponseEntity.ok(List.of("Nima","Nima2","Nima4"));
    }

}
