package com.example.amirs_jpa.controller;

import com.example.amirs_jpa.dto.GroupDto;
import com.example.amirs_jpa.entity.Group;
import com.example.amirs_jpa.repo.GroupRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/groups")
@CrossOrigin
public class GroupsController {
    @Autowired
    GroupRepo groupRepo;

    @GetMapping
    public ResponseEntity<?> getAllGroups(){
        List<Group> all = groupRepo.findAll();
        return ResponseEntity.ok(all);
    }

    @PostMapping
    public ResponseEntity<?> saveGroup(@RequestBody GroupDto dto){
        Group group = new Group(dto.getName());
        Group save = groupRepo.save(group);
        return ResponseEntity.ok(save);
    }


}
