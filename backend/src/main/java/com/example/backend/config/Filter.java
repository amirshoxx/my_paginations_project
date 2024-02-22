package com.example.backend.config;

import com.example.backend.db.Db;
import com.example.backend.entity.User;
import com.example.backend.enums.Role;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Configuration
public class Filter extends OncePerRequestFilter {

    private List<Security> securities = new ArrayList<>(List.of(
            new Security("/task", "POST", List.of(Role.ROLE_ADMIN, Role.ROLE_SUPER_ADMIN)),
            new Security("/task", "DELETE", List.of(Role.ROLE_SUPER_ADMIN))
    ));

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String url = request.getRequestURI();
        String method = request.getMethod();

        if (isProtected(url, method)!=null){
            String token = request.getHeader("token");

            for (User user : Db.users) {
                if (user.getId().toString().equals(token)){

                    if (isProtected(url, method).contains(user.getRole())){
                        filterChain.doFilter(request,response);
                    }
                    break;
                }
            }
        }else {
            filterChain.doFilter(request,response);
        }
    }

    protected List<Role> isProtected(String url, String method){
        for (Security security : securities) {
            if ((url.startsWith(security.getUrl()) || security.getUrl().equals(url)) && security.getMethod().equals(method)) {
                return security.getRoles();
            }
        }
        return null;
    }
}
