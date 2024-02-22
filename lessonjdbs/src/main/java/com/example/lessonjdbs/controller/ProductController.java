package com.example.lessonjdbs.controller;

import com.example.lessonjdbs.dto.InvoiceDto;
import com.example.lessonjdbs.entity.Users;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/product")
public class ProductController {
    final JdbcTemplate jdbcTemplate;

    public ProductController(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @GetMapping()
    public ResponseEntity<?> getProduct(){
        List<Users> query = jdbcTemplate.query("select * from product", BeanPropertyRowMapper.newInstance(Users.class));
        return ResponseEntity.ok(query);
    }

     @PostMapping()
    public ResponseEntity<?> postInvoice(@RequestBody InvoiceDto dto){
         int update = jdbcTemplate.update("insert into invoice values(default,?,?,?,?)",dto.getProduct_id(),dto.getUser_id(),dto.getSale_price(),dto.getQuantity());
         return ResponseEntity.ok(update);
     }
}
