package com.example.amirsjpatask.dto;

import lombok.Getter;

@Getter
public class TaskDto {
    private String  name;
    private Boolean active;
    private String preority;
    private Long categoryId;
}
