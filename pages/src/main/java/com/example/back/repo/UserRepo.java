package com.example.back.repo;

import com.example.back.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Integer> {
    void deleteAllById(Integer id);
}
