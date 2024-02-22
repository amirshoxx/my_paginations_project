package com.example.spring_security_jjwt.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity(name="products")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Double price;
    private Integer count;
    private String description;
}