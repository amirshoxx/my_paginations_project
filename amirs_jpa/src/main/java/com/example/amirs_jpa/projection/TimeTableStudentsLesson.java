package com.example.amirs_jpa.projection;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TimeTableStudentsLesson {
    private Long id;
    private String title;
    private String description;
    private Integer mark;
    private Boolean active;
}
