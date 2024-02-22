package com.example.projectlibrary.controllers;

import com.example.projectlibrary.dto.OrderDto;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.web.bind.annotation.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

@RestController
@RequestMapping
@CrossOrigin
public class OrderController {

    final JdbcTemplate jdbcTemplate;

    public OrderController(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @PostMapping
    public ResponseEntity<?> saveOrder(@RequestBody OrderDto dto){
        GeneratedKeyHolder holder = new GeneratedKeyHolder();
        jdbcTemplate.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
                PreparedStatement preparedStatement = con.prepareStatement("insert into orders(user_id) values (?)",
                        Statement.RETURN_GENERATED_KEYS);
                preparedStatement.setInt(1,dto.getUserId());
                return preparedStatement;
            }
        },holder);
        return ResponseEntity.ok("order saved");

    }
}
