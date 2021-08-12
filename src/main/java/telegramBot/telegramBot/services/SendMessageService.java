package telegramBot.telegramBot.services;

import org.telegram.telegrambots.meta.api.objects.Message;

public interface SendMessageService {

    void send(Message message);
}