package com.example.springfirst.payload;

import com.example.springfirst.entity.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReqRequest {
    private String url;
    private String method;

}
