package com.example.beckend.Controller;
import com.example.beckend.entity.Address;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;



@CrossOrigin
@RestController
@RequestMapping("/address")
public class AddressController {
    final JdbcTemplate jdbcTemplate;

    public AddressController(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @GetMapping
    public ResponseEntity<?> getAdress() {
        List<Address> results = jdbcTemplate.query(
                "SELECT t.user_id,u.adress_id, t.name, t.status, t.type, t.created_at, u.img, a.city, a.country_code FROM tasks t " +
                        "INNER JOIN users u ON t.user_id = u.id " +
                        "INNER JOIN address a ON u.adress_id = a.id",
                BeanPropertyRowMapper.newInstance(Address.class));

        return ResponseEntity.ok(results);
    }

}
