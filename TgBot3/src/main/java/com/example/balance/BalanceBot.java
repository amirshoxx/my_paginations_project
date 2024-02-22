package com.example.balance;

import lombok.SneakyThrows;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BalanceBot extends TelegramLongPollingBot {

    @Override
    public String getBotUsername() {
        return "authenfication_bot";
    }

    @Override
    public String getBotToken() {
        return "6751007893:AAE-Q-6R_eyqRu5aXnp5ZmCGK2_bax1xrAY";
    }

    @SneakyThrows
    @Override
    public void onUpdateReceived(Update update) {
        User user = selectUser(update.getMessage().getChatId());
        if (user == null) {
            user = new User(update.getMessage().getChatId(), null);
            Db.users.add(user);
        }


        if (update.hasMessage()) {
            if (update.getMessage().getText().equals("/start")) {
                List<KeyboardRow> rows = new ArrayList<>();
                KeyboardRow row = new KeyboardRow();
                KeyboardRow row2 = new KeyboardRow();
                rows.add(row);
                rows.add(row2);

                KeyboardButton keyboardButton = new KeyboardButton();
                keyboardButton.setText("Kirim Qilish");
                row.add(keyboardButton);

                KeyboardButton keyboardButton2 = new KeyboardButton();
                keyboardButton2.setText("Chiqim Qilish");
                row.add(keyboardButton2);

                KeyboardButton keyboardButton3 = new KeyboardButton();
                keyboardButton3.setText("Hisobni Ko'rish");
                row2.add(keyboardButton3);

                KeyboardButton keyboardButton4 = new KeyboardButton();
                keyboardButton4.setText("Tarixni Ko'rish");
                row2.add(keyboardButton4);

                ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
                replyKeyboardMarkup.setKeyboard(rows);
                replyKeyboardMarkup.setOneTimeKeyboard(true);
                replyKeyboardMarkup.setResizeKeyboard(true);

                SendMessage message = new SendMessage();
                message.setText("Menu⚙️");
                message.setReplyMarkup(replyKeyboardMarkup);

                message.setChatId(update.getMessage().getChatId().toString());

                execute(message);
            } else if (update.getMessage().getText().equals("Kirim Qilish")) {
                user.setStatus(IncomeStatus.TYPE);

                List<KeyboardRow> rows = new ArrayList<>();
                KeyboardRow row = new KeyboardRow();
                rows.add(row);

                KeyboardButton keyboardButton = new KeyboardButton();
                keyboardButton.setText("Naqt");
                row.add(keyboardButton);

                KeyboardButton keyboardButton2 = new KeyboardButton();
                keyboardButton2.setText("Karta");
                row.add(keyboardButton2);

                ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
                replyKeyboardMarkup.setKeyboard(rows);
                replyKeyboardMarkup.setOneTimeKeyboard(true);
                replyKeyboardMarkup.setResizeKeyboard(true);

                SendMessage message = new SendMessage();
                message.setText("To'lov Turini Kiriting");
                message.setReplyMarkup(replyKeyboardMarkup);

                message.setChatId(update.getMessage().getChatId().toString());

                execute(message);
            } else if (user.status.equals(IncomeStatus.TYPE)) {
                user.setStatus(IncomeStatus.AMOUNT);
                Income income = new Income(update.getMessage().getText(), null);
                Db.incomes.add(income);
                SendMessage message = new SendMessage();
                message.setText("To'lov Miqdorini Kiriting");
                message.setChatId(update.getMessage().getChatId().toString());

                execute(message);
            } else if (user.status.equals(IncomeStatus.AMOUNT)) {
                user.setStatus(IncomeStatus.NONE);
                for (Income income : Db.incomes) {
                    if (income.amount == null) {
                        income.amount = Integer.valueOf(update.getMessage().getText());
                    }
                }
                List<KeyboardRow> rows = new ArrayList<>();
                KeyboardRow row = new KeyboardRow();
                KeyboardRow row2 = new KeyboardRow();
                rows.add(row);
                rows.add(row2);

                KeyboardButton keyboardButton = new KeyboardButton();
                keyboardButton.setText("Kirim Qilish");
                row.add(keyboardButton);

                KeyboardButton keyboardButton2 = new KeyboardButton();
                keyboardButton2.setText("Chiqim Qilish");
                row.add(keyboardButton2);

                KeyboardButton keyboardButton3 = new KeyboardButton();
                keyboardButton3.setText("Hisobni Ko'rish");
                row2.add(keyboardButton3);

                KeyboardButton keyboardButton4 = new KeyboardButton();
                keyboardButton4.setText("Tarixni Ko'rish");
                row2.add(keyboardButton4);

                ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
                replyKeyboardMarkup.setKeyboard(rows);
                replyKeyboardMarkup.setOneTimeKeyboard(true);
                replyKeyboardMarkup.setResizeKeyboard(true);

                SendMessage message = new SendMessage();
                message.setText("Menu⚙️");
                message.setReplyMarkup(replyKeyboardMarkup);

                message.setChatId(update.getMessage().getChatId().toString());
                execute(message);
            } else if (update.getMessage().getText().equals("Chiqim Qilish")) {
                user.setStatus(ExpenseStatus.TYPE);

                List<KeyboardRow> rows = new ArrayList<>();
                KeyboardRow row = new KeyboardRow();
                rows.add(row);

                KeyboardButton keyboardButton = new KeyboardButton();
                keyboardButton.setText("Naqt");
                row.add(keyboardButton);

                KeyboardButton keyboardButton2 = new KeyboardButton();
                keyboardButton2.setText("Karta");
                row.add(keyboardButton2);

                ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
                replyKeyboardMarkup.setKeyboard(rows);
                replyKeyboardMarkup.setOneTimeKeyboard(true);
                replyKeyboardMarkup.setResizeKeyboard(true);

                SendMessage message = new SendMessage();
                message.setText("To'lov Turini Kiriting");
                message.setReplyMarkup(replyKeyboardMarkup);

                message.setChatId(update.getMessage().getChatId().toString());

                execute(message);
            } else if (user.status.equals(ExpenseStatus.TYPE)) {
                user.setStatus(ExpenseStatus.AMOUNT);
                Expense expense = new Expense(update.getMessage().getText(), null);
                Db.expenses.add(expense);
                SendMessage message = new SendMessage();
                message.setText("To'lov Miqdorini Kiriting");
                message.setChatId(update.getMessage().getChatId().toString());

                execute(message);
            } else if (user.status.equals(ExpenseStatus.AMOUNT)) {
                user.setStatus(ExpenseStatus.NONE);
                for (Expense expense : Db.expenses) {
                    if (expense.amount == null) {
                        expense.amount = Integer.valueOf(update.getMessage().getText());
                    }
                }
                List<KeyboardRow> rows = new ArrayList<>();
                KeyboardRow row = new KeyboardRow();
                KeyboardRow row2 = new KeyboardRow();
                rows.add(row);
                rows.add(row2);

                KeyboardButton keyboardButton = new KeyboardButton();
                keyboardButton.setText("Kirim Qilish");
                row.add(keyboardButton);

                KeyboardButton keyboardButton2 = new KeyboardButton();
                keyboardButton2.setText("Chiqim Qilish");
                row.add(keyboardButton2);

                KeyboardButton keyboardButton3 = new KeyboardButton();
                keyboardButton3.setText("Hisobni Ko'rish");
                row2.add(keyboardButton3);

                KeyboardButton keyboardButton4 = new KeyboardButton();
                keyboardButton4.setText("Tarixni Ko'rish");
                row2.add(keyboardButton4);

                ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
                replyKeyboardMarkup.setKeyboard(rows);
                replyKeyboardMarkup.setOneTimeKeyboard(true);
                replyKeyboardMarkup.setResizeKeyboard(true);

                SendMessage message = new SendMessage();
                message.setText("Menu⚙️");
                message.setReplyMarkup(replyKeyboardMarkup);

                message.setChatId(update.getMessage().getChatId().toString());
                execute(message);
            } else if ("Tarixni Ko'rish".equals(update.getMessage().getText())) {
                List<KeyboardRow> rows = new ArrayList<>();
                KeyboardRow row = new KeyboardRow();
                rows.add(row);

                KeyboardButton keyboardButton = new KeyboardButton();
                keyboardButton.setText("Kirimlarni Ko'rish");
                row.add(keyboardButton);

                KeyboardButton keyboardButton2 = new KeyboardButton();
                keyboardButton2.setText("Chiqimlarni Ko'rish");
                row.add(keyboardButton2);

                ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
                replyKeyboardMarkup.setKeyboard(rows);
                replyKeyboardMarkup.setOneTimeKeyboard(true);
                replyKeyboardMarkup.setResizeKeyboard(true);

                SendMessage message = new SendMessage();
                message.setText("Tanlang:");
                message.setChatId(update.getMessage().getChatId());
                message.setReplyMarkup(replyKeyboardMarkup);
                execute(message);
            } else if ("Kirimlarni Ko'rish".equals(update.getMessage().getText())) {
                SendMessage message = new SendMessage();
                message.setText(Db.incomes.toString());
                message.setChatId(update.getMessage().getChatId());
                execute(message);
                List<KeyboardRow> rows = new ArrayList<>();
                KeyboardRow row = new KeyboardRow();
                KeyboardRow row2 = new KeyboardRow();
                rows.add(row);
                rows.add(row2);

                KeyboardButton keyboardButton = new KeyboardButton();
                keyboardButton.setText("Kirim Qilish");
                row.add(keyboardButton);

                KeyboardButton keyboardButton2 = new KeyboardButton();
                keyboardButton2.setText("Chiqim Qilish");
                row.add(keyboardButton2);

                KeyboardButton keyboardButton3 = new KeyboardButton();
                keyboardButton3.setText("Hisobni Ko'rish");
                row2.add(keyboardButton3);

                KeyboardButton keyboardButton4 = new KeyboardButton();
                keyboardButton4.setText("Tarixni Ko'rish");
                row2.add(keyboardButton4);

                ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
                replyKeyboardMarkup.setKeyboard(rows);
                replyKeyboardMarkup.setOneTimeKeyboard(true);
                replyKeyboardMarkup.setResizeKeyboard(true);

                SendMessage message1 = new SendMessage();
                message1.setText("Menu⚙️");
                message1.setReplyMarkup(replyKeyboardMarkup);
                message1.setChatId(update.getMessage().getChatId().toString());
                execute(message1);
            } else if ("Chiqimlarni Ko'rish".equals(update.getMessage().getText())) {
                SendMessage message = new SendMessage();
                message.setText(Db.expenses.toString());
                message.setChatId(update.getMessage().getChatId());
                execute(message);
                List<KeyboardRow> rows = new ArrayList<>();
                KeyboardRow row = new KeyboardRow();
                KeyboardRow row2 = new KeyboardRow();
                rows.add(row);
                rows.add(row2);

                KeyboardButton keyboardButton = new KeyboardButton();
                keyboardButton.setText("Kirim Qilish");
                row.add(keyboardButton);

                KeyboardButton keyboardButton2 = new KeyboardButton();
                keyboardButton2.setText("Chiqim Qilish");
                row.add(keyboardButton2);

                KeyboardButton keyboardButton3 = new KeyboardButton();
                keyboardButton3.setText("Hisobni Ko'rish");
                row2.add(keyboardButton3);

                KeyboardButton keyboardButton4 = new KeyboardButton();
                keyboardButton4.setText("Tarixni Ko'rish");
                row2.add(keyboardButton4);

                ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
                replyKeyboardMarkup.setKeyboard(rows);
                replyKeyboardMarkup.setOneTimeKeyboard(true);
                replyKeyboardMarkup.setResizeKeyboard(true);

                SendMessage message1 = new SendMessage();
                message1.setText("Menu⚙️");
                message1.setReplyMarkup(replyKeyboardMarkup);
                message1.setChatId(update.getMessage().getChatId().toString());
                execute(message1);
            } else if ("Hisobni Ko'rish".equals(update.getMessage().getText())) {
                SendMessage message = new SendMessage();
                message.setText(String.valueOf(Db.allBalance()));
                message.setChatId(update.getMessage().getChatId().toString());
                execute(message);
                
            }
        }
    }


    public User selectUser(Long id) {
        for (User user : Db.users) {
            if (user.getId().equals(id)) {
                return user;
            }
        }
        return null;
    }
}
