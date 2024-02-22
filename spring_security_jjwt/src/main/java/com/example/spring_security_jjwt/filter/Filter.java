package com.example.spring_security_jjwt.filter;
import com.example.spring_security_jjwt.entity.User;
import com.example.spring_security_jjwt.repspo.UserRepo;
import com.example.spring_security_jjwt.security.service.JwtService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import java.io.IOException;
@Component
@Configuration
@RequiredArgsConstructor
public class Filter extends OncePerRequestFilter {
    private final JwtService service;
    private final UserRepo userService;
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String authorization = request.getParameter("Authorization");
        if (authorization != null) {
            Jws<Claims> jws = service.extractJwt(authorization);
            Claims user = jws.getPayload();
            String id = user.getSubject();
            User optionalUser = userService.findById(Long.parseLong(id)).get();
          UsernamePasswordAuthenticationToken upat = new UsernamePasswordAuthenticationToken(
                    optionalUser.getUsername(),
                        optionalUser.getPassword(),
                    optionalUser.getAuthorities()
            );
           SecurityContextHolder.getContext().setAuthentication(upat);
        }
        filterChain.doFilter(request, response);
    }
}
