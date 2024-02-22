package com.example.lessonjdbs.controller;

import com.example.lessonjdbs.dto.UserDto;
import com.example.lessonjdbs.entity.FrontEnd;
import com.example.lessonjdbs.entity.Users;
import com.example.lessonjdbs.entity.userId;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/users")
public class UserController {
    final JdbcTemplate jdbcTemplate;

    public UserController(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @GetMapping()
    public ResponseEntity<?> getUsers(){
        List<Users> query = jdbcTemplate.query("select * from users", BeanPropertyRowMapper.newInstance(Users.class));
        return ResponseEntity.ok(query);
    }

    @PostMapping()
    public ResponseEntity<?> postUsers(@RequestBody UserDto dto){
        int update = jdbcTemplate.update("insert into users values(default,?,?)",dto.getName(),dto.getPhone());
        return ResponseEntity.ok(update);
    }
    @GetMapping("/all")
    public ResponseEntity<?>getAllProject(){
        List<FrontEnd> query = jdbcTemplate.query("select i.product_id,pr.description,pr.product_type,pr.brand_name,i.quantity,pr.coast_price,i.sale_price,u.name,u.phone from product pr inner join invoice i on pr.id = i.product_id inner join users u on i.user_id = u.id", BeanPropertyRowMapper.newInstance(FrontEnd.class));
        return ResponseEntity.ok(query);
    }


    @GetMapping("/userId")
    public ResponseEntity<?>getUserId(){
        List<userId> query = jdbcTemplate.query("select i.id, u.name , i.user_id from users u inner join invoice i on u.id = i.user_id", BeanPropertyRowMapper.newInstance(userId.class));
        return ResponseEntity.ok(query);
    }
}
