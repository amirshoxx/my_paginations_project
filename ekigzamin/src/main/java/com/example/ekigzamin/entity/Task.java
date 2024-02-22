package com.example.ekigzamin.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Task {
    private UUID id;
    private String name;
    private LocalDateTime localDateTime;
    private String priority;
    private UUID categoryId;
    private boolean completed;

}
