package com.example.productinfodb.controller;

import com.example.productinfodb.dto.ProductRes;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
@CrossOrigin
public class ProductController {

    private final JdbcTemplate jdbcTemplate;

    public ProductController(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @GetMapping("/{id}")
    public ResponseEntity<?> getProductDesc(@PathVariable Integer id){
        var sql = "select p.id, p.name, p.price, d.text from products p join description d on p.description_id = d.id where p.id =?";
        ProductRes productRes = jdbcTemplate.queryForObject(sql, BeanPropertyRowMapper.newInstance(ProductRes.class),id);
        return ResponseEntity.ok(productRes);
    }

}
