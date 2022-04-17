package com.dns.telegramBot.services;

import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;

import java.util.Locale;

@Service
public class SendMessageServiceImpl implements SendMessageService{

    private final OpenWeatherMapService openWeatherMapService;

    private final MessageSource messageSource;

    public SendMessageServiceImpl(OpenWeatherMapServiceImpl openWeatherMapService,
                                  MessageSource messageSource) {
        this.openWeatherMapService = openWeatherMapService;
        this.messageSource = messageSource;
    }

    @Override
    public SendMessage send(Message message) {
        String result = "/start".equals(message.getText())
                ? messageSource.getMessage("greeting", null, Locale.ENGLISH)
                : openWeatherMapService.getWeatherInfo(message.getText());

        return SendMessage.builder()
                .text(result)
                .parseMode("HTML")
                .chatId(String.valueOf(message.getChatId()))
                .build();
    }
}