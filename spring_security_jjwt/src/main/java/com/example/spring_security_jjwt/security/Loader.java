package com.example.spring_security_jjwt.security;

import com.example.spring_security_jjwt.entity.Role;
import com.example.spring_security_jjwt.repspo.RoleRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
@RequiredArgsConstructor
public class Loader implements CommandLineRunner {
    private final RoleRepo roleRepo;

    @Override
    public void run(String... args) throws Exception {
        List<Role> all = roleRepo.findAll();
        if (all.isEmpty()) {
            List<Role> roles = List.of(
                    Role.builder()
                            .name("ROLE_ADMIN")
                            .build(),
                    Role.builder()
                            .name("ROLE_USER")
                            .build()
            );
            roleRepo.saveAll(roles);
        }
    }
}
