package com.example.beckend.Controller;

import com.example.beckend.Controller.Dto.TroggerDto;
import com.example.beckend.FrontData.UserFront;
import com.example.beckend.FrontData.troggerFront;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/trogger")
public class TroggerController {
    final JdbcTemplate jdbcTemplate;

    public TroggerController(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    @GetMapping
    public ResponseEntity<List<troggerFront>> getTrogger() {
        List<troggerFront> query = jdbcTemplate.query("SELECT * FROM trogger",
                BeanPropertyRowMapper.newInstance(troggerFront.class));

        return ResponseEntity.ok(query);
    }
    @PostMapping
    public ResponseEntity<?> saveTrogger(@RequestBody TroggerDto troggerDto) {
        String sql = "INSERT INTO trogger ( name, status) VALUES ( ?, ?)";

        jdbcTemplate.update(
                sql,
                troggerDto.getName(),
                troggerDto.getStatus()

        );
        return ResponseEntity.ok("Trogger saved successfully");

    }
}
