package com.example.spring_security_jjwt.repspo;

import com.example.spring_security_jjwt.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepo extends JpaRepository<Product,Long> {
}