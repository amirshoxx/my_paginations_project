package com.example.chat_app_project.dto;

import lombok.Getter;

import java.util.UUID;

@Getter
public class MessageDto {
private String text;
private UUID fromId;
private UUID toId;
}
