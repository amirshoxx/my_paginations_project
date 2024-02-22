package com.example.beckend.Controller;

import com.example.beckend.Controller.Dto.UsersDTO;
import com.example.beckend.FrontData.UserFront;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/user")
public class UsersController {
    final JdbcTemplate jdbcTemplate;

    public UsersController(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @GetMapping
    public ResponseEntity<List<UserFront>> getUser() {
        List<UserFront> query = jdbcTemplate.query("SELECT * FROM trousers",
                BeanPropertyRowMapper.newInstance(UserFront.class));

        return ResponseEntity.ok(query);
    }

    @PostMapping
    public ResponseEntity<String> saveUser(@RequestBody UsersDTO usersDTO) {
        String sql = "INSERT INTO trousers (full_name, img) VALUES (?, ?)";

        jdbcTemplate.update(
                sql,
                usersDTO.getFull_name(),
                usersDTO.getImg()
        );

        return ResponseEntity.ok("User saved successfully");
    }
}
