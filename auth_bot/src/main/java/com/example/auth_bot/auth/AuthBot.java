package com.example.auth_bot.auth;

import com.example.auth_bot.db.Db;
import com.example.auth_bot.entity.User;
import lombok.SneakyThrows;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.CallbackQuery;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;

import java.util.ArrayList;
import java.util.List;

public class AuthBot extends TelegramLongPollingBot {
    int a = 3;

    @SneakyThrows
    @Override
    public void onUpdateReceived(Update update) {

        if (update.hasMessage()) {
            SendMessage sendMessage = new SendMessage();
            sendMessage.setChatId(update.getMessage().getChatId());
            sendMessage.setText("Tilni tanlang");
            sendMessage.setReplyMarkup(getntleBtns());
            execute(sendMessage);
        } else if (update.hasCallbackQuery()) {
            CallbackQuery callbackQuery = update.getCallbackQuery();
            String data = callbackQuery.getData();
            Long chatId = callbackQuery.getFrom().getId();
            SendMessage sendMessage = new SendMessage();
            if (data.equals("INGLIZ TILI TANLANDI")) {
                sendMessage.setText(data + " ing ");
                a++;
            } else {
                sendMessage.setText(data + "Uzb");
                a--;
            }
            sendMessage.setChatId(chatId);
            sendMessage.setReplyMarkup(getntleBtns());
            execute(sendMessage);
        }

    }

    private User selectUser(Long chatId) {
        for (User user : Db.users) {
            if (user.getChatId().equals(chatId)) {
                return user;
            }
        }
        User user = new User(chatId);
        Db.users.add(user);
        return user;
    }

    private InlineKeyboardMarkup getntleBtns() {

        List<List<InlineKeyboardButton>> rows = new ArrayList<>();
        List<InlineKeyboardButton> row = new ArrayList<>();
        rows.add(row);
        InlineKeyboardButton button = new InlineKeyboardButton();
        button.setText("\uD83C\uDDFA\ud83c\uddf8 En");
        button.setCallbackData("INGLIZ TILI TANLANDI");
        row.add(button);


        InlineKeyboardButton button4 = new InlineKeyboardButton();
        button4.setText(String.valueOf(a));
        button4.setCallbackData("Counter kamaydi");
        row.add(button4);


        InlineKeyboardButton button1 = new InlineKeyboardButton();
        button1.setText("\uD83C\uDDFA\uD83C\uDDFF Uz");
        button1.setCallbackData("UZBEK TILI TANLANDI");
        row.add(button1);
        return new InlineKeyboardMarkup(rows);
    }

    @Override
    public String getBotToken() {
        return "6751007893:AAE-Q-6R_eyqRu5aXnp5ZmCGK2_bax1xrAY";
    }

    @Override
    public String getBotUsername() {
        return "authenfication_bot";
    }
}
