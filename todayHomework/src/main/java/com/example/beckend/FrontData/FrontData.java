package com.example.beckend.FrontData;

import com.example.beckend.FrontData.UserFront;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FrontData {
    private Integer troggerId;
    private String name;
    private String status;
    private List<UserFront> users;


}
