package com.example.backend.entity;

import com.example.backend.enums.Status;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class Task {
    private Integer id;
    private String title;
    private Status status;
    private static int lastId;

    public Task(String title, Status status) {
        this.id = ++lastId;
        this.title = title;
        this.status = status;
    }
}
