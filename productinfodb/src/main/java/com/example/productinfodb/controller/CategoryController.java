package com.example.productinfodb.controller;

import com.example.productinfodb.dto.ProductRes;
import com.example.productinfodb.entity.Category;
import com.example.productinfodb.entity.Product;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/category")
@CrossOrigin
public class CategoryController {

    private final JdbcTemplate jdbcTemplate;

    public CategoryController(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @GetMapping
    public ResponseEntity<?> getCategories(){
        var sql = "select * from category";
        List<Category> query = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Category.class));
        return ResponseEntity.ok(query);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getCategoryProducts(@PathVariable Integer id){
        var sql = "select * from product p join category c on p.category_id = ?;";
        List<Product> products = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Product.class), id);
        return ResponseEntity.ok(products);
    }



}
