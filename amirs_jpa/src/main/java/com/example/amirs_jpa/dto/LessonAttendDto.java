package com.example.amirs_jpa.dto;

import lombok.Getter;

@Getter
public class LessonAttendDto {
    private Boolean active;
    private Integer mark;
    private Long lessonId;
    private Long timeTableStudentId;
}
