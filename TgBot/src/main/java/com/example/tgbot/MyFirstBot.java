package com.example.tgbot;

import com.pengrad.telegrambot.request.SendMessage;
import lombok.SneakyThrows;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.util.ArrayList;
import java.util.List;


public class MyFirstBot extends TelegramLongPollingBot {

    @SneakyThrows
    @Override
    public void onUpdateReceived(Update update) {
        Message message = update.getMessage();
      Long chatId = message.getChatId();
        if (message.getText().equals("/start")) {
            User user = new User();
           execute();
        }


    }

    @Override
    public String getBotToken() {
        return "6336163097:AAGIu9gEibuwYugMrAiYvHnDgiywDVv43Ok";
    }

    @Override
    public String getBotUsername() {
        return "amirake_bot";
    }
}
