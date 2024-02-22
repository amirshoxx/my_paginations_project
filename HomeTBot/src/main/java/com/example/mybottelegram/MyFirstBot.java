package com.example.mybottelegram;

import lombok.SneakyThrows;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.ArrayList;
import java.util.List;

public class MyFirstBot extends TelegramLongPollingBot {
    List<String> strings = new ArrayList<>();

    @Override
    public String getBotUsername() {
        return "t.me/authenfication_bot";
    }

    @Override
    public String getBotToken() {
        return "6751007893:AAE-Q-6R_eyqRu5aXnp5ZmCGK2_bax1xrAY";
    }

    @SneakyThrows
    @Override
    public void onUpdateReceived(Update update) {
        Message message = update.getMessage();
        Long chatId = message.getChatId();
        User user = selectUser(chatId);

        if (user==null){
            user = new User(chatId);
            Db.users.add(user);
        }
        if (message.getText() != null) {
            if (message.getText().equalsIgnoreCase("/start") && message.hasContact()){
                user.setStatus(States.SET_CONTACT);
                SendMessage sendMessage = new SendMessage();
                sendMessage.setText(" account add ");
                sendMessage.setChatId(chatId);
                user.setContact(message.getContact().getPhoneNumber());
                List<KeyboardRow>keyboardRowList = new ArrayList<>();
                KeyboardRow keyboardRow = new KeyboardRow();
                KeyboardButton keyboardButton = new KeyboardButton();
                keyboardButton.setText("Share Contact");
                keyboardButton.setRequestContact(true);
                keyboardRow.add(keyboardButton);
                keyboardRowList.add(keyboardRow);
                ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup(keyboardRowList);
                replyKeyboardMarkup.setResizeKeyboard(true);
                sendMessage.setReplyMarkup(replyKeyboardMarkup);
                try {
                    execute(sendMessage);
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
            }

        else if (user.getStatus().equals(States.SET_CONTACT) && message.hasContact()) {
                user.setStatus(States.SET_LOCATION);
                SendMessage sendMessage = new SendMessage();
                sendMessage.setText(" account add ");
                sendMessage.setChatId(chatId);
                List<KeyboardRow>keyboardRowList = new ArrayList<>();
                KeyboardRow keyboardRow = new KeyboardRow();
                KeyboardButton keyboardButton = new KeyboardButton();
                keyboardButton.setText("Share Location");
                keyboardButton.setRequestLocation(true);
                keyboardRow.add(keyboardButton);
                keyboardRowList.add(keyboardRow);
                ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup(keyboardRowList);
                replyKeyboardMarkup.setResizeKeyboard(true);
                sendMessage.setReplyMarkup(replyKeyboardMarkup);

                try {
                    execute(sendMessage);
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
            } else if (user.getStatus().equals(States.SET_FIRSTNAME)) {
                user.setStatus(States.SET_LASTNAME);
                user.setFirstName(message.getText());
                SendMessage sendMessage = new SendMessage();
                sendMessage.setChatId(chatId);
                sendMessage.setText("bro what is your LastName? ");
                try {
                    execute(sendMessage);
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
            } else if (user.getStatus().equals(States.SET_LASTNAME)) {
                user.setStatus(States.SET_FROM);
                user.setLastName(message.getText());
                SendMessage sendMessage = new SendMessage();
                sendMessage.setChatId(chatId);
                sendMessage.setText("your phone number? ");
                try {
                    execute(sendMessage);
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
            } else if (user.getStatus().equals(States.SET_FROM)) {
                user.setStatus(States.SET_CITY);
                user.setFrom(message.getText());
                SendMessage sendMessage = new SendMessage();
                sendMessage.setChatId(chatId);
                sendMessage.setText("what city are you from ");
                try {
                    execute(sendMessage);
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
            } else if (user.getStatus().equals(States.SET_CITY)) {
                user.setStatus(States.SET_STREET);
                user.setCity(message.getText());
                SendMessage sendMessage = new SendMessage();
                sendMessage.setChatId(chatId);
                sendMessage.setText("what street are you from? ");
                try {
                    execute(sendMessage);
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
            } else if (user.getStatus().equals(States.SET_STREET)) {
                user.setStreet(message.getText());
                user.setStatus(States.SET_PHONE);
                SendMessage sendMessage = new SendMessage();
                sendMessage.setChatId(chatId);
                sendMessage.setText("your phone number?");
                try {
                    execute(sendMessage);

                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }

            } else if (user.getStatus().equals(States.SET_PHONE)) {
                user.setPhone(message.getText());
                user.setStatus(States.SET_HOME_PHONE);
                SendMessage sendMessage = new SendMessage();
                sendMessage.setChatId(chatId);
                sendMessage.setText("your home phone Number?");
                try {
                    execute(sendMessage);

                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }

            } else if (user.getStatus().equals(States.SET_HOME_PHONE)) {
                user.setHomePhone(message.getText());
                user.setStatus(States.SET_ADD_PHONE);
                SendMessage sendMessage = new SendMessage();
                sendMessage.setChatId(chatId);
                sendMessage.setText("your Add phone Number?");
                try {
                    execute(sendMessage);

                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }

            } else if (user.getStatus().equals(States.SET_ADD_PHONE)) {
                user.setAddPhone(message.getText());
                user.setStatus(States.SET_BIRTHDAY);
                SendMessage sendMessage = new SendMessage();
                sendMessage.setChatId(chatId);
                sendMessage.setText("your birthday?");
                try {
                    execute(sendMessage);

                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }

            } else if (user.getStatus().equals(States.SET_BIRTHDAY)) {
                user.setBirthday(message.getText());
                user.setStatus(States.SET_BUTTON);
                SendMessage sendMessage = new SendMessage();
                sendMessage.setChatId(chatId);
                sendMessage.setText("select the button");


                try {

                    execute(sendMessage);

                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }

//            } else if (user.getStatus().equals(States.SET_BUTTON)) {
//                user.setButton(message.getText());
//                SendMessage sendMessage = new SendMessage();
//                sendMessage.setChatId(chatId);
//                sendMessage.setText("I am glad to meet you \uD83E\uDD17 " + message.getChat().getUserName());
//
//                System.out.println(Db.users);
//                ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
//                replyKeyboardMarkup.setResizeKeyboard(true);
//                replyKeyboardMarkup.setSelective(true);
//                List<KeyboardRow> keyboardRowList = new ArrayList<>();
//                KeyboardRow keyboardRow1 = new KeyboardRow();
//                KeyboardRow keyboardRow2 = new KeyboardRow();
//
//                KeyboardButton keyboardButton1 = new KeyboardButton();
//                keyboardButton1.setText("textTanlang\uD83D\uDE02");
//                keyboardButton1.setRequestContact(true);
////               keyboardButton1.setRequestLocation(true);
//                keyboardRow1.add(keyboardButton1);
//
//                KeyboardButton keyboardButton2 = new KeyboardButton();
//                keyboardButton2.setText("Hello\uD83E\uDD13");
//                keyboardRow1.add(keyboardButton2);
//
//
//                KeyboardButton keyboardButton3 = new KeyboardButton();
//                keyboardButton3.setText("click\uD83D\uDE08");
//                keyboardRow2.add(keyboardButton3);
//
//                KeyboardButton keyboardButton4 = new KeyboardButton();
//                keyboardButton4.setText("showMe\uD83E\uDEE1");
//                keyboardRow2.add(keyboardButton4);
//                ;
//
//                KeyboardButton keyboardButton5 = new KeyboardButton();
//                keyboardButton5.setText("whatIs\uD83D\uDE22");
//                keyboardRow2.add(keyboardButton5);
//
//                keyboardRowList.add(keyboardRow1);
//                keyboardRowList.add(keyboardRow2);
//
//                replyKeyboardMarkup.setKeyboard(keyboardRowList);
//                sendMessage.setReplyMarkup(replyKeyboardMarkup);
//                if (message.getText().equals("textTanlang\uD83D\uDE02")) {
//                    sendMessage.setChatId(chatId);
//                    sendMessage.setText("xush kelibsiz");
//                } else if (message.getText().equals("Hello\uD83E\uDD13")) {
//                    sendMessage.setChatId(chatId);
//                    sendMessage.setText("hi bro or mis");
//                } else if (message.getText().equals("click\uD83D\uDE08")) {
//                    sendMessage.setChatId(chatId);
//                    sendMessage.setText("uxladiz");
//                } else if (message.getText().equals("showMe\uD83E\uDEE1")) {
//                    sendMessage.setChatId(chatId);
//                    sendMessage.setText("nimadir");
//                } else if (message.getText().equals("whatIs\uD83D\uDE22")) {
//                    sendMessage.setChatId(chatId);
//                    sendMessage.setText("your name");
//                }
//                try {
//
//                    execute(sendMessage);
//
//                } catch (TelegramApiException e) {
//                    e.printStackTrace();
//                }

            } else if (message.getText() == null) {
                user.setStatus(States.START);
                message.setText("/start");
            }

        }







    }



    private User selectUser(Long chatId){
        for (User user : Db.users) {
            if (user.getChatId().equals(chatId)){
                return user;
            }
        }
        return null;
    }

}
