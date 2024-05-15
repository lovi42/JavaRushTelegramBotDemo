package com.javarush.telegrambot;

import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageText;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

import java.util.Map;

import static com.javarush.telegrambot.TelegramBotContent.FINAL_TEXT;
import static com.javarush.telegrambot.TelegramBotContent.STEP_1_TEXT;
import static com.javarush.telegrambot.TelegramBotContent.STEP_2_TEXT;
import static com.javarush.telegrambot.TelegramBotContent.STEP_3_TEXT;
import static com.javarush.telegrambot.TelegramBotContent.STEP_4_TEXT;
import static com.javarush.telegrambot.TelegramBotContent.STEP_5_TEXT;
import static com.javarush.telegrambot.TelegramBotContent.STEP_6_TEXT;
import static com.javarush.telegrambot.TelegramBotContent.STEP_7_TEXT;
import static com.javarush.telegrambot.TelegramBotContent.STEP_8_TEXT;

public class MyFirstTelegramBot extends MultiSessionTelegramBot {
    public static final String NAME = "jrmarathon120524_bot";
    public static final String TOKEN = "7128712280:AAEuILtQ7RJ54GJeFEsEXVo1xtPUnBp5Wlg";

    public MyFirstTelegramBot() {
        super(NAME, TOKEN);
    }

    @Override
    public void onUpdateEventReceived(Update updateEvent) {
        if (getMessageText().equals("/start")) {
            setUserGlory(0);
            sendImageMessageAsync("src/main/resources/images/step_1_pic.jpg");
            sendTextMessageAsync(STEP_1_TEXT, Map.of("Взлом холодильника", "step1_btn"));
        }

        if (getCallbackQueryButtonKey().equals("step1_btn")) {
            addUserGlory(20);
            sendImageMessageAsync("src/main/resources/images/step_2_pic.jpg");
            sendTextMessageAsync(STEP_2_TEXT, Map.of(
                    "Взять сосиску! +20 славы", "step2_btn1",
                    "Взять рыбку! +20 славы", "step2_btn2",
                    "Сбросить банку з огурцами! +20 славы", "step2_btn3")
            );
        }

        if (getCallbackQueryButtonKey().startsWith("step2_btn")) {
            addUserGlory(20);
            sendImageMessageAsync("src/main/resources/images/step_3_pic.jpg");
            sendTextMessageAsync(STEP_3_TEXT, Map.of("Взлом робота пылесоса", "step3_btn"));
        }

        if (getCallbackQueryButtonKey().equals("step3_btn")) {
            addUserGlory(30);
            sendImageMessageAsync("src/main/resources/images/step_4_pic.jpg");
            sendTextMessageAsync(STEP_4_TEXT, Map.of(
                    "Отправить робопылесос за едой! +30 славы", "step4_btn1",
                    "Проехаться на робопылесосе! +30 славы", "step4_btn2",
                    "Убегать от робопылесоса! +30 славы", "step4_btn3")
            );
        }

        if (getCallbackQueryButtonKey().startsWith("step4_btn")) {
            addUserGlory(30);
            sendImageMessageAsync("src/main/resources/images/step_5_pic.jpg");
            sendTextMessageAsync(STEP_5_TEXT, Map.of("Надеть и включить GoPro!", "step5_btn"));
        }

        if (getCallbackQueryButtonKey().equals("step5_btn")) {
            addUserGlory(40);
            sendImageMessageAsync("src/main/resources/images/step_6_pic.jpg");
            sendTextMessageAsync(STEP_6_TEXT, Map.of(
                    "Бегать по крышам, снимать на GoPro! +40 славы", "step6_btn1",
                    "С GoPro нападать на других котов из засады! +40 славы", "step6_btn2",
                    "С GoPro нападать на собак из засады! +40 славы", "step6_btn3")
            );
        }

        if (getCallbackQueryButtonKey().startsWith("step6_btn")) {
            addUserGlory(40);
            sendImageMessageAsync("src/main/resources/images/step_7_pic.jpg");
            sendTextMessageAsync(STEP_7_TEXT, Map.of("Взлом пароля", "step7_btn"));
        }

        if (getCallbackQueryButtonKey().equals("step7_btn")) {
            addUserGlory(50);
            sendImageMessageAsync("src/main/resources/images/step_8_pic.jpg");
            sendTextMessageAsync(STEP_8_TEXT, Map.of("Выйти во двор", "step8_btn"));
        }

        if (getCallbackQueryButtonKey().equals("step8_btn")) {
            addUserGlory(50);
            sendImageMessageAsync("src/main/resources/images2/cat_hhl.jpg");
            sendTextMessageAsync(FINAL_TEXT);
        }

        if (getMessageText().equals("/glory")) {
            sendTextMessageAsync("Glory points: " + getUserGlory());
        }
    }

    public static void main(String[] args) throws TelegramApiException {
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
        telegramBotsApi.registerBot(new MyFirstTelegramBot());
    }
}