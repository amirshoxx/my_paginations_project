package com.example;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.model.request.KeyboardButton;
import com.pengrad.telegrambot.model.request.ReplyKeyboardMarkup;
import com.pengrad.telegrambot.request.SendMessage;

import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

public class TelegramBotUpdateHandler {
    Map<Long, Step> USER_STATE = new HashMap<>();


    public Boolean handle(Update update) {
        TelegramBot telegramBot = new TelegramBot(TelegramBotApplication.botToken);
        ResourceBundle resourceBundle = TelegramBotApplication.resourceBundle;
        var message = update.message();
        var chat = message.chat();
        var chatId = chat.id();
        var text = message.text();
        var from = message.from();
        var firstName = from.firstName();
        SendMessage sendMessage;
        USER_STATE.put(chatId,Step.START);
        User user = new User();
        if (!text.isEmpty() && text !=null) {
            if (text.equals("/start")) {
                sendMessage = new SendMessage(chatId,
                        "Assalomu alaykum %s, %s botimizga hush kelibsiz".formatted(
                                firstName, resourceBundle.getString("amirake_bot")));
                KeyboardButton keyboardButton = new KeyboardButton(Step.REGISTER.toString());
                ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup(keyboardButton);
                sendMessage.replyMarkup(replyKeyboardMarkup);
                replyKeyboardMarkup.resizeKeyboard(true);
                telegramBot.execute(sendMessage);
                USER_STATE.put(chatId,Step.REGISTER);
            }else if (USER_STATE.containsKey(chatId) && USER_STATE.get(chatId).equals(Step.REGISTER)) {
                sendMessage = new SendMessage(chatId, "Ismingizni kiriitng");
                telegramBot.execute(sendMessage);
                USER_STATE.put(chatId,Step.NAME);
            } else if (USER_STATE.containsKey(chatId) && USER_STATE.get(chatId).equals(Step.NAME)) {
                user.setName(text);
                sendMessage = new SendMessage(chatId,"Yoshingizni kiritng");
                telegramBot.execute(sendMessage);
                USER_STATE.put(chatId,Step.AGE);
            } else if (USER_STATE.containsKey(chatId) && USER_STATE.get(chatId).equals(Step.AGE)) {
                user.setAge(Integer.parseInt(text));
                sendMessage = new SendMessage(chatId, "Joylashuvingizni yuboring yuboring");
                KeyboardButton keyboardButton = new KeyboardButton("Share Location \uD83D\uDCCD");
                ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup(keyboardButton);
                sendMessage.replyMarkup(replyKeyboardMarkup);
                replyKeyboardMarkup.resizeKeyboard(true);
                keyboardButton.requestLocation(true);
                telegramBot.execute(sendMessage);
                USER_STATE.put(chatId,Step.LOCATION);
            }  else if (USER_STATE.containsKey(chatId) && USER_STATE.get(chatId).equals(Step.NAME)) {
                user.setNumber(message.contact().phoneNumber());
                Db.users.add(user);
                System.out.println(user);
                System.out.println(Db.users);
            }
            return true;
        } else if (text == null) {
            if  (USER_STATE.containsKey(chatId) && USER_STATE.get(chatId).equals(Step.LOCATION) ) {
                user.setLatitude(message.location().latitude());
                user.setLongitude(message.location().longitude());
                sendMessage = new SendMessage(chatId, "Telefon raqamingizni yuboring");
                KeyboardButton keyboardButton = new KeyboardButton("Share Phone Number \uD83D\uDCDE");
                ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup(keyboardButton);
                sendMessage.replyMarkup(replyKeyboardMarkup);
                replyKeyboardMarkup.resizeKeyboard(true);
                keyboardButton.requestContact(true);
                telegramBot.execute(sendMessage);
                USER_STATE.put(chatId,Step.NUMBER);
                System.out.println(user);
                System.out.println(Db.users);
            }
            return true;
        } else {
            System.out.println("xato");
            return false;
        }


    }
}
