package com.example.balance;

import com.example.balance.BalanceBot;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

@SpringBootApplication
public class BalanceApplication {

	public static void main(String[] args) throws TelegramApiException {
		SpringApplication.run(BalanceApplication.class, args);
		TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
		BalanceBot myFirstBot = new BalanceBot();
		telegramBotsApi.registerBot(myFirstBot);
	}
}
