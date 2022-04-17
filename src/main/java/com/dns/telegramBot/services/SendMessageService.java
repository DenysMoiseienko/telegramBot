package com.dns.telegramBot.services;

import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;

import java.util.Locale;

@Service
public class SendMessageService {

    private final OpenWeatherMapClient openWeatherMapClient;

    private final MessageSource messageSource;

    public SendMessageService(OpenWeatherMapClient openWeatherMapClient, MessageSource messageSource) {
        this.openWeatherMapClient = openWeatherMapClient;
        this.messageSource = messageSource;
    }

    public SendMessage send(Message message) {
        String result = "/start".equals(message.getText())
                ? messageSource.getMessage("greeting", null, Locale.ENGLISH)
                : openWeatherMapClient.getWeatherInfo(message.getText());

        return SendMessage.builder()
                .text(result)
                .parseMode("HTML")
                .chatId(String.valueOf(message.getChatId()))
                .build();
    }
}