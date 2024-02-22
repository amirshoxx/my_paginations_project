package com.example.beckend.Controller;

import com.example.beckend.Controller.Dto.UsersDTO;
import com.example.beckend.FrontData.FrontData;
import com.example.beckend.FrontData.Many;
import com.example.beckend.FrontData.UserFront;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.sql.Array;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/troggertrousers")
public class TroggerTroUsersController {
    final JdbcTemplate jdbcTemplate;

    public TroggerTroUsersController(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @GetMapping
    public ResponseEntity<?> getTroggerTroUsers() {
        String sql = "SELECT tro.trogger_id, t.name, t.status, " +
                "json_agg(json_build_object('id', u.id, 'full_name', u.full_name, 'img', u.img)) AS users " +
                "FROM trogger_trousers tro " +
                "INNER JOIN trogger t ON t.id = tro.trogger_id " +
                "INNER JOIN trousers u ON tro.trousers_id = u.id " +
                "GROUP BY tro.trogger_id, t.name, t.status";

        List<FrontData> query = jdbcTemplate.query(sql, ((rs, row) -> {
            Array users = rs.getArray("users");
            ObjectMapper objectMapper = new ObjectMapper();
            List<UserFront> userFronts;
            try {
                userFronts = objectMapper.readValue(users.toString(), new TypeReference<List<UserFront>>() {});
            } catch (JsonProcessingException e) {
                throw new RuntimeException(e);
            }

            return new FrontData(
                    rs.getInt("trogger_id"),
                    rs.getString("name"),
                    rs.getString("status"),
                    userFronts
            );
        }));

        return ResponseEntity.ok(query);
    }
    @PostMapping
    public ResponseEntity<String> saveTroggerto(@RequestBody Many many) {
        if (many.getTroggerId() == null || many.getTrousersId() == null) {
            return ResponseEntity.badRequest().body("TroggerId and TrousersId cannot be null");
        }

        String sql = "INSERT INTO trogger_trousers (trousers_id, trogger_id) VALUES (?, ?)";

        jdbcTemplate.update(
                sql,
                many.getTrousersId(),
                many.getTroggerId()
        );

        return ResponseEntity.ok("User saved successfully");
    }
    @GetMapping("/{name}")
    public ResponseEntity<?> search(@PathVariable String name) {
        String query = "SELECT tro.trogger_id, count(t.name), count(t.status), " +
                "json_agg(json_build_object('id', u.id, 'full_name', u.full_name, 'img', u.img)) AS users " +
                "FROM trogger_trousers tro " +
                "INNER JOIN trogger t ON t.id = tro.trogger_id " +
                "INNER JOIN trousers u ON tro.trousers_id = u.id " +
                "WHERE t.name ILIKE '%" + name + "%' " +
                "GROUP BY tro.trogger_id";

        List<FrontData> results = jdbcTemplate.query(query, (rs, row) -> {
            Array users = rs.getArray("users");
            ObjectMapper objectMapper = new ObjectMapper();
            List<UserFront> userFronts;
            try {
                userFronts = objectMapper.readValue(users.toString(), new TypeReference<List<UserFront>>() {});
            } catch (JsonProcessingException e) {
                throw new RuntimeException(e);
            }

            return new FrontData(
                    rs.getInt("trogger_id"),
                    rs.getString("name"),
                    rs.getString("status"),
                    userFronts
            );
        });

        return ResponseEntity.ok(results);
    }




}
