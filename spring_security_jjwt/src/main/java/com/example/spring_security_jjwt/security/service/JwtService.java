package com.example.spring_security_jjwt.security.service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;

import javax.crypto.SecretKey;

public interface JwtService {

    String generateJwt(String id);
    SecretKey signInWithKey();
  Jws<Claims> extractJwt(String jwt);

}
