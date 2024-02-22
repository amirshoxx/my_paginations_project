package com.example.beckend.Controller;

import com.example.beckend.entity.Tasks;
import com.example.beckend.entity.UserDto;
import com.example.beckend.projection.TaskFront;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin
@RestController
@RequestMapping("/task")
public class TaskController {
    final JdbcTemplate jdbcTemplate;


    public TaskController(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @GetMapping
    public ResponseEntity<?> getTask() {
        List<?> results = jdbcTemplate.query(
                "SELECT t.id,t.user_id,u.adress_id,u.first_name,u.img, t.name," +
                        " a.country_code,a.city, t.status, t.type, t.created_at," +
                        " u.img, a.city, a.country_code FROM tasks t " +
                        "INNER JOIN users u ON t.user_id = u.id " +
                        "INNER JOIN address a ON u.adress_id = a.id",
                BeanPropertyRowMapper.newInstance(TaskFront.class));

        return ResponseEntity.ok(results);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> del(@PathVariable Integer id){
        int rowsAffected = jdbcTemplate.update("DELETE FROM tasks WHERE id = ?", id);

        if (rowsAffected > 0) {
            return ResponseEntity.ok("Task with id " + id + " deleted successfully.");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Task with id " + id + " not found.");
        }
    }
    @GetMapping("/{name}")
    public ResponseEntity<?> search(@PathVariable String name) {
        String query = "SELECT t.id,t.user_id,u.adress_id,u.first_name,u.img, t.name," +
                " a.country_code,a.city, t.status, t.type, t.created_at," +
                " u.img, a.city, a.country_code FROM tasks t " +
                "INNER JOIN users u ON t.user_id = u.id " +
                "INNER JOIN address a ON u.adress_id = a.id " +
                "WHERE t.name ilike '%" + name + "%'";

        List<?> results = jdbcTemplate.query(query, BeanPropertyRowMapper.newInstance(TaskFront.class));

        return ResponseEntity.ok(results);
    }
    @PostMapping
    public ResponseEntity<?> saveUser(@RequestBody UserDto userDto) {
        int rowsAffected = jdbcTemplate.update(
                "INSERT INTO tasks (name, status, type, user_id) VALUES (?, ?, ?, ?)",
                userDto.getName(), userDto.getStatus(), userDto.getType(), userDto.getUserId()
        );

        if (rowsAffected > 0) {
            return ResponseEntity.ok("Task saved successfully.");
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to save task.");
        }
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> editTask(@PathVariable Integer id, @RequestBody UserDto userDto) {
        MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
        mapSqlParameterSource.addValue("name", userDto.getName());
        mapSqlParameterSource.addValue("status", userDto.getStatus());
        mapSqlParameterSource.addValue("type", userDto.getType());
        mapSqlParameterSource.addValue("userId", userDto.getUserId());
        mapSqlParameterSource.addValue("id", id); // Use the provided id parameter

        NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(jdbcTemplate);

        int rowsAffected = namedParameterJdbcTemplate.update(
                "UPDATE tasks SET name=:name, status=:status, type=:type, user_id=:userId WHERE id=:id",
                mapSqlParameterSource
        );

        if (rowsAffected > 0) {
            return ResponseEntity.ok("Task updated successfully.");
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to update task.");
        }
    }




}
