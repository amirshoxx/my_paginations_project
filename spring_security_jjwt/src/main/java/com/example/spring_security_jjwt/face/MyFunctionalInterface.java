package com.example.spring_security_jjwt.face;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

@FunctionalInterface
public interface MyFunctionalInterface {
   UserDetails loadByUsername(String username) throws UsernameNotFoundException;
}
