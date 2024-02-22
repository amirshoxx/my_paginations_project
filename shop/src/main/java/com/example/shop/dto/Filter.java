package com.example.shop.dto;

import com.example.shop.db.Db;
import com.example.shop.entity.Role;
import com.example.shop.entity.User;
import com.example.shop.repository.SecurityRes;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.SneakyThrows;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.List;


@Configuration
public class Filter extends OncePerRequestFilter {
    private List<SecurityRes> securityRes = List.of(
            new SecurityRes("/admin","GET",List.of(Role.ROLE_ADMIN,Role.ROLE_USER)),
            new SecurityRes("/admin/me","GET",List.of(Role.ROLE_ADMIN,Role.ROLE_USER)),
            new SecurityRes("/admin/users","GET",List.of(Role.ROLE_ADMIN)),
            new SecurityRes("/category","POST",List.of(Role.ROLE_ADMIN)),
            new SecurityRes("/product","POST",List.of(Role.ROLE_ADMIN)),
            new SecurityRes("/product","GET",List.of(Role.ROLE_ADMIN,Role.ROLE_USER)),
            new SecurityRes("/category","GET",List.of(Role.ROLE_ADMIN,Role.ROLE_USER))
    );

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        if(isProtected(request)){
                String token = request.getHeader("token");
            for (User user : Db.users) {
                if(user.getId().toString().equals(token)){
                     checkRoles(request,response,user,filterChain);
                    break;
                }
            }
        }else {
            filterChain.doFilter(request,response);
        }

    }

    boolean isProtected(HttpServletRequest request){
        String url = request.getRequestURI();
        String method = request.getMethod();
        for (SecurityRes security : securityRes) {
            if (security.getUrl().equals(url)&&security.getMethod().equals(method)){
                  return true;
            }
        }
        return false;
    }

    @SneakyThrows
    void checkRoles(HttpServletRequest request, HttpServletResponse response, User user, FilterChain filterChain){
        String url =request.getRequestURI();
        String method= request.getMethod();
        for (SecurityRes security : securityRes) {
            if(security.getUrl().equals(url) &&security.getMethod().equals(method)){

                if (security.getRoles().contains(user.getRole())){
                    filterChain.doFilter(request,response);
                }
                break;

            }
        }
    }

}
