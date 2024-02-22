package com.example.tg_bt.bot;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;

public class MyFirstBot extends TelegramLongPollingBot {

    @Override
    public String getBotUsername() {
        return "amirake_bot";
    }

    @Override
    public String getBotToken() {
        return "6336163097:AAGIu9gEibuwYugMrAiYvHnDgiywDVv43Ok";
    }

    @Override
    public void onUpdateReceived(Update update) {
        System.out.println("salom");
    }
}
