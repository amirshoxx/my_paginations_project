package com.example.chat_app_project.repo;

import com.example.chat_app_project.entity.User;
import com.example.chat_app_project.projection.MessageProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface UserRepo extends JpaRepository<User, Long> {
    @Query( value = "select * from users where users.id !=:fromId",nativeQuery = true)
    List<User> allUsers(UUID fromId);


    User getByEmailAndPassword(String email, String password);
}
