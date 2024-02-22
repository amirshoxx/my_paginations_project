package com.example.spring_security_jjwt.controller;

import com.example.spring_security_jjwt.dto.ProductDto;
import com.example.spring_security_jjwt.entity.Product;
import com.example.spring_security_jjwt.security.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productServise;
    @GetMapping()
    public HttpEntity<?> getProduct(){
        return ResponseEntity.ok(productServise.getAllProduct());
    }
    @PostMapping()
    public Product addProduct(
            @RequestBody ProductDto dto){
        return productServise.addProduct(dto);
    }

    @DeleteMapping
    public HttpEntity<?> deleteCategory(@RequestParam Long id) {
    return  ResponseEntity.ok(productServise.deleteProduct(id));
    }

}
