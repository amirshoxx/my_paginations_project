package com.example.spring_security_jjwt.controller;

import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/secure")
@CrossOrigin
public class TestController {

    @GetMapping("/list")
    public HttpEntity<?>openApi(){
        return ResponseEntity.ok(List.of("Nsaima","Nssima2","Nisma4"));
    }






//    @PreAuthorize("hasRole('USER')")
//    @GetMapping("/student")
//    public HttpEntity<?> getOPenApi(){
//        return ResponseEntity.ok("Hello from OpenAi");
//    }
//    @PreAuthorize("hasRole('ADMIN')")
//    @GetMapping("/secure/student")
//    public HttpEntity<?> getSecureApi(){
//        return ResponseEntity.ok("Hello from Secure");
//    }
//
//    @GetMapping("/")
//    public HttpEntity<?> getSlesh(){
//        return ResponseEntity.ok("Hello from Slesh  ");
//    }
}
