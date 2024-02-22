package com.example.amirs_jpa.repo;

import com.example.amirs_jpa.entity.Group;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface GroupRepo extends JpaRepository<Group,Long> {


    Group getGroupById(Long groupId);



}
