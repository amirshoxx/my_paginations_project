package com.example.spring_ended_project.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Modul {
    private UUID id;
    private String title;
    private String desc;
    private UUID courseId;
}
