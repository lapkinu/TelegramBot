package com.javarush.telegrambot;

import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageText;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

import java.util.Map;

import static com.javarush.telegrambot.TelegramBotContent.*;

public class MyFirstTelegramBot extends MultiSessionTelegramBot {
    public static final String NAME = "lapMyFirstChatInJava_bot";
    public static final String TOKEN = "6412538076:AAEWYQl5NYzUH4gh0eqJk4Aog2JIfix1RQo";

    public MyFirstTelegramBot() {
        super(NAME, TOKEN);
    }

    @Override
    public void onUpdateEventReceived(Update updateEvent) {
        if (getMessageText().toLowerCase().contains("привет")) {
            setUserGlory(0);
            sendPhotoMessageAsync("step_1_pic");
            sendTextMessageAsync(STEP_1_TEXT, Map.of("Взлом холодильника", "STEP_1_btn"));
        }
        if (getCallbackQueryButtonKey().equals("STEP_1_btn")) {
            setUserGlory(20);
            sendPhotoMessageAsync("step_2_pic");
            sendTextMessageAsync(STEP_2_TEXT,
                     Map.of("Взять сосиску! +20 славы", "STEP_2_btn",
                            "Взять рыбку! +20 славы", "STEP_2_btn",
                            "Сбросить банку з огурцами! +20 славы", "STEP_2_btn"));
        }
        if (getCallbackQueryButtonKey().equals("STEP_2_btn")) {
            setUserGlory(20);
            sendPhotoMessageAsync("step_3_pic");
            sendTextMessageAsync(STEP_3_TEXT,
                     Map.of("Взлом робота пылесоса", "STEP_3_btn"));
        }
        if (getCallbackQueryButtonKey().equals("STEP_3_btn")) {
            setUserGlory(30);
            sendPhotoMessageAsync("step_4_pic");
            sendTextMessageAsync(STEP_4_TEXT,
                     Map.of("Отправить робот-пылесос за едой! +30 славы", "STEP_4_btn",
                            "Проехаться на роботе-пылесосе! +30 славы", "STEP_4_btn",
                            "Убегать от робота-пылесоса! +30 славы", "STEP_4_btn"));
        }
        if (getCallbackQueryButtonKey().equals("STEP_4_btn")) {
            setUserGlory(30);
            sendPhotoMessageAsync("step_5_pic");
            sendTextMessageAsync(STEP_5_TEXT,
                    Map.of("Надеть и включить GoPro", "STEP_5_btn"));
        }
        if (getCallbackQueryButtonKey().equals("STEP_5_btn")) {
            setUserGlory(40);
            sendPhotoMessageAsync("step_6_pic");
            sendTextMessageAsync(STEP_6_TEXT,
                     Map.of("Бегать по крышам, снимать на GoPro! +40 славы", "STEP_6_btn",
                            "С GoPro нападать на других котов из засады! +40 славы", "STEP_6_btn",
                            "С GoPro нападать на собак из засады! +40 славы", "STEP_6_btn"));
        }
        if (getCallbackQueryButtonKey().equals("STEP_6_btn")) {
            setUserGlory(40);
            sendPhotoMessageAsync("step_7_pic");
            sendTextMessageAsync(STEP_7_TEXT,
                    Map.of("Взлом пароля", "STEP_7_btn"));
        }
        if (getCallbackQueryButtonKey().equals("STEP_7_btn")) {
            setUserGlory(50);
            sendPhotoMessageAsync("step_8_pic");
            sendTextMessageAsync(STEP_8_TEXT,
                    Map.of("Выйти во двор", "STEP_8_btn"));
        }
        if (getCallbackQueryButtonKey().equals("STEP_8_btn")) {
            sendPhotoMessageAsync("final_pic");
            sendTextMessageAsync(FINAL_TEXT);
        }
        if (getMessageText().equals("/glory")) {
            sendTextMessageAsync("_Накоплено:_ " +  getUserGlory() +  " _ славы_");
        }

    }

    public static void main(String[] args) throws TelegramApiException {
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
        telegramBotsApi.registerBot(new MyFirstTelegramBot());
    }
}