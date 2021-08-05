package telegramBot.telegramBot.services;

import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import telegramBot.telegramBot.messageSender.MessageSender;

@Service
public class SendMessageService {

    private final MessageSender messageSender;
    private final WeatherAPI weatherAPI;

    public SendMessageService(MessageSender messageSender, WeatherAPI weatherAPI) {
        this.messageSender = messageSender;
        this.weatherAPI = weatherAPI;
    }

    public void send(Message message) {
        SendMessage sm = SendMessage.builder()
                .text(weatherAPI.getWeatherInfo(message.getText()))
                .chatId(String.valueOf(message.getChatId()))
                .build();
        messageSender.sendMessage(sm);
    }
}