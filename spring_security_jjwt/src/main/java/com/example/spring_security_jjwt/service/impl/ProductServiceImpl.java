package com.example.spring_security_jjwt.service.impl;

import com.example.spring_security_jjwt.dto.ProductDto;
import com.example.spring_security_jjwt.entity.Product;
import com.example.spring_security_jjwt.repspo.ProductRepo;
import com.example.spring_security_jjwt.security.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
        private final ProductRepo productRepo;

        @Override
        public List<Product> getAllProduct() {
            return productRepo.findAll();
        }

        @Override
        public Product addProduct(ProductDto dto) {
            Product build = Product.builder()
                    .name(dto.name())
                    .count(dto.count())
                    .price(dto.price())
                    .description(dto.description())
                    .build();
            return productRepo.save(build);
        }

        @Override
        public Product deleteProduct(Long id) {
            productRepo.deleteById(id);
            return null;
        }

}
