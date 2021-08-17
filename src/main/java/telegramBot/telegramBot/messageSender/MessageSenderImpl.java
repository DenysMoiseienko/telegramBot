package telegramBot.telegramBot.messageSender;

import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import telegramBot.telegramBot.Bot;

@Service
public class MessageSenderImpl implements MessageSender{

    private final Bot bot;

    public MessageSenderImpl(Bot bot) {
        this.bot = bot;
    }

    @Override
    public void sendMessage(SendMessage message) {
        try {
            bot.execute(message);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}