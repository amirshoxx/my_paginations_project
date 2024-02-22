package com.example.auth_bot.entity;

import com.example.auth_bot.entity.enums.ForM;
import com.example.auth_bot.entity.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private Long chatId;
    private String firstName;
    private String lastName;
    private String age;
    private Status status = Status.START;
    private Address address;
    private String phoneNumber;
    private ForM form;
    private Integer counter;
    private String comment;
    public User(Long chatId) {
        this.chatId = chatId;
    }
}
