package com.example.shop.repository;


import com.example.shop.entity.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SecurityRes {
    private String url;
    private String method;
    private List<Role> roles;
}
