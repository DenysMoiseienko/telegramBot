package telegramBot.telegramBot.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import telegramBot.telegramBot.messageSender.MessageSender;

@Service
public class SendMessageService {

    private final MessageSender messageSender;
    private final WeatherAPI weatherAPI;

    private MessageSource messageSource;

    public SendMessageService(MessageSender messageSender, WeatherAPI weatherAPI) {
        this.messageSender = messageSender;
        this.weatherAPI = weatherAPI;
    }

    @Autowired
    public void setMessageSource(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    public void send(Message message) {
        String result = "/start".equals(message.getText())
                ? messageSource.getMessage("greeting", null, null)
                : weatherAPI.getWeatherInfo(message.getText());

        SendMessage sm = SendMessage.builder()
                .text(result)
                .parseMode("HTML")
                .chatId(String.valueOf(message.getChatId()))
                .build();

        messageSender.sendMessage(sm);
    }
}