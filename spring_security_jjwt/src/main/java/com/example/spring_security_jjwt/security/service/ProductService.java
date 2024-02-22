package com.example.spring_security_jjwt.security.service;

import com.example.spring_security_jjwt.dto.ProductDto;
import com.example.spring_security_jjwt.entity.Product;

import java.util.List;

public interface ProductService {
    List<Product> getAllProduct();
    Product addProduct(ProductDto dto);
    Product deleteProduct(Long id);

}
