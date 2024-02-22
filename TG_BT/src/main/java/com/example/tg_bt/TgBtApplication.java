package com.example.tg_bt;

import com.example.tg_bt.bot.MyFirstBot;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;


@SpringBootApplication
public class TgBtApplication {

    public static void main(String[] args) throws TelegramApiException {
        SpringApplication.run(TgBtApplication.class, args);
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
        MyFirstBot myFirstBot = new MyFirstBot();
        telegramBotsApi.registerBot(myFirstBot);
    }

}
