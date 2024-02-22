package com.example.auth_bot;

import com.example.auth_bot.auth.AuthBot;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

@SpringBootApplication
public class AuthBotApplication {

    public static void main(String[] args) throws TelegramApiException {
        SpringApplication.run(AuthBotApplication.class, args);
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
        AuthBot authBot = new AuthBot();
        telegramBotsApi.registerBot(authBot);
    }

}
