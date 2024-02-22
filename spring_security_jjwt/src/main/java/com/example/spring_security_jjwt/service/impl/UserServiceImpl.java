package com.example.spring_security_jjwt.service.impl;

import com.example.spring_security_jjwt.dto.LoginDto;
import com.example.spring_security_jjwt.dto.RegisterDto;
import com.example.spring_security_jjwt.entity.Role;
import com.example.spring_security_jjwt.entity.User;
import com.example.spring_security_jjwt.repspo.RoleRepo;
import com.example.spring_security_jjwt.repspo.UserRepo;
import com.example.spring_security_jjwt.security.service.JwtService;
import com.example.spring_security_jjwt.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepo userRepo;
    private final RoleRepo roleRepo;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;

    @Override
    public Optional<User> register(RegisterDto dto) {
        Optional<Role> roleUser = roleRepo.findByName("ROLE_USER");
        User user  = new User();
        user.setEmail(dto.username());
        user.setPassword(passwordEncoder.encode(dto.password()));
        user.setRoles(List.of(roleUser.get()));
        User saved = userRepo.save(user);
        return Optional.of(saved);
    }

    @Override
    public String login(LoginDto dto) {
        User user = userRepo.findByEmail(dto.username()).get();
        Long id = user.getId();
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        dto.username(),
                        dto.password()
                )
        );


        String jwt = jwtService.generateJwt(id.toString());

        return jwt;
    }

    @Override
    public Optional<User> findUserById(Long id) {
        Optional<User> byId = userRepo.findById(id);
        return byId;
    }
}
