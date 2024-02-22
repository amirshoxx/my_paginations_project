package com.example.newtgbot;

import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiRequestException;
import org.telegram.telegrambots.meta.generics.BotOptions;
import org.telegram.telegrambots.meta.generics.LongPollingBot;

public class MyFirstBot implements LongPollingBot {
    @Override
    public void onUpdateReceived(Update update) {

    }

    @Override
    public BotOptions getOptions() {
        return null;
    }

    @Override
    public void clearWebhook() throws TelegramApiRequestException {

    }

    @Override
    public String getBotUsername() {
        return "amirake_bot";
    }

    @Override
    public String getBotToken() {
        return "6336163097:AAGIu9gEibuwYugMrAiYvHnDgiywDVv43Ok";
    }
}
