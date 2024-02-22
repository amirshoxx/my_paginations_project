package com.example.mybottelegram;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class User  {
    private Long chatId;
    private String lastName;
    private String firstName;
    private String from;
    private String city;
    private String street;
    private String Phone;
    private String HomePhone;
    private String AddPhone;
    private String birthday;
    private String Button;
    private String Contact;
    private String Location;
    private String generate;
    private String sport;

    private States status = States.START;
    public User(Long chatId) {
        this.chatId = chatId;
    }



}
