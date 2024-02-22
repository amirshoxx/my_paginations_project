package com.example.springfirst.config;

import com.example.springfirst.DB.DB;
import com.example.springfirst.entity.Role;
import com.example.springfirst.entity.User;
import com.example.springfirst.payload.ReqRequest;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;


public class Filter extends OncePerRequestFilter {



    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String parameter = request.getHeader("key");
        String requestURI=request.getRequestURI();

        String method = request.getMethod();
        if (method.equals("OPTIONS")){
            filterChain.doFilter(request,response);
            return;
        }



        if(requestURI.equals("/user/auth")){
            filterChain.doFilter(request,response);
        }
       if(request.getRequestURI().equals("/task")){
           for (User user : DB.users) {
               if(
               user.getId().toString().equals(parameter)
               ){
                   filterChain.doFilter(request,response);
               }else {
                   return;
               }
           }
       }





























//filterChain.doFilter(request,response);
    }


//    List<ReqRequest> reqRequests = List.of(
//            new ReqRequest("/task","get"),
//            new ReqRequest("/task","post"),
//            new ReqRequest("/task/assign","post"),
//            new ReqRequest("/task","put"),
//            new ReqRequest("/user","get"),
//            new ReqRequest("/user/task","get")
//    );
//
//
//
//    @Override
//    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
//        String requestURI = request.getRequestURI();
//        String method = request.getMethod();
//        if (method.equals("OPTIONS")){
//            filterChain.doFilter(request,response);
//            return;
//        }
//        String parameter = request.getHeader("key");
//        if (requestURI.equals("/user/auth")){
//            filterChain.doFilter(request,response);
//        }else {
//            for (User user : DB.users) {
//                if (checkRoleUser(parameter,requestURI,method)){
//                    filterChain.doFilter(request,response);
//                    break;
//                }
//            }
//        }



    //}

//    private boolean checkRoleUser(String parameter, String requestURI, String method) {
//        for (User user : DB.users) {
//            for (ReqRequest reqRequest : reqRequests) {
//                if (parameter.equals(user.getId().toString()) && requestURI.equals(reqRequest.getUrl()) && method.toLowerCase().equals(reqRequest.getMethod()) ){
//                   return true;
//                }
//            }
//        }
//        return false;
//    }
}
