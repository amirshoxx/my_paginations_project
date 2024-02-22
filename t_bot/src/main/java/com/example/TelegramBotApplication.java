//package com.example;
//
//
//import com.pengrad.telegrambot.TelegramBot;
//import com.pengrad.telegrambot.UpdatesListener;
//import com.pengrad.telegrambot.model.Update;
//import com.pengrad.telegrambot.request.SendMessage;
//import com.pengrad.telegrambot.response.SendResponse;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//
//import java.util.ResourceBundle;
//import java.util.concurrent.CompletableFuture;
//
//@SpringBootApplication
//public class TelegramBotApplication {
//
//    public static ResourceBundle resourceBundle = ResourceBundle.getBundle("amirake_bot");
//  public static   String botToken= resourceBundle.getString("6336163097:AAGIu9gEibuwYugMrAiYvHnDgiywDVv43Ok");
//
//    public static void main(String[] args) {
//        var bot = new TelegramBot("6336163097:AAGIu9gEibuwYugMrAiYvHnDgiywDVv43Ok");
//       var telegramBotUpdateHandler = new TelegramBotUpdateHandler();
//        bot.setUpdatesListener(list -> {
//            for (Update update : list){
//                telegramBotUpdateHandler.handle(update);
//            }
//            return UpdatesListener.CONFIRMED_UPDATES_ALL;
//        });
//    }
//
//}

package com.example;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.UpdatesListener;
import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.request.SendMessage;
import com.pengrad.telegrambot.response.SendResponse;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ResourceBundle;
import java.util.concurrent.CompletableFuture;

@SpringBootApplication
public class TelegramBotApplication {

    // Load the resource bundle using the class loader
    public static ResourceBundle resourceBundle = ResourceBundle.getBundle("amirake_bot");

    // Retrieve the bot token from the resource bundle
    public static String botToken = resourceBundle.getString("6336163097:AAGIu9gEibuwYugMrAiYvHnDgiywDVv43Ok");

    public static void main(String[] args) {
        var bot = new TelegramBot(botToken); // Use the retrieved bot token
        var telegramBotUpdateHandler = new TelegramBotUpdateHandler();
        bot.setUpdatesListener(list -> {
            for (Update update : list) {
                telegramBotUpdateHandler.handle(update);
            }
            return UpdatesListener.CONFIRMED_UPDATES_ALL;
        });
    }
}