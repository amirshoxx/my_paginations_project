package com.example.spring_security_jjwt.security;

import com.example.spring_security_jjwt.entity.User;
import com.example.spring_security_jjwt.filter.Filter;
import com.example.spring_security_jjwt.repspo.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import java.util.ArrayList;
import java.util.Optional;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
@RequiredArgsConstructor
public class SecurityConfig  {

    private final UserRepo userRepo;
    private final Filter filter;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
      httpSecurity.cors(AbstractHttpConfigurer::disable).csrf(AbstractHttpConfigurer::disable).authorizeHttpRequests(
              auth ->auth
                      .requestMatchers("/loginA").permitAll()
                      .requestMatchers("/register").permitAll()
                      .requestMatchers("/").permitAll()
                      .requestMatchers("/product").permitAll()
                      .requestMatchers("/openForAll").permitAll()
                          .anyRequest().authenticated()
            ).addFilterBefore(filter, UsernamePasswordAuthenticationFilter.class);
        return httpSecurity.build();
    }


    @Bean
    public UserDetailsService userDetailsService(){
       return username -> {
           User user = userRepo.findByEmail(username)
                   .orElseThrow(() -> new UsernameNotFoundException("User Not found "));
           return new org.springframework.security.core.userdetails.User(
                 user.getUsername(),
                   user.getPassword(),
                  new ArrayList<>()
         );
       };
    }

    @Bean
    public BCryptPasswordEncoder encoder(){return new BCryptPasswordEncoder();}

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception{
        return configuration.getAuthenticationManager();
    }
}
