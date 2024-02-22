package com.example.springfirst.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Task {
    private UUID id;
    private String title;
    private String description;
    private TaskStatus status;

    public Task(UUID id, String eeeeeee, String rreeedrrrrr, WorkType workType) {
    }
}
