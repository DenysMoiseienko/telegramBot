package telegramBot.telegramBot.messageSender;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageText;

public interface MessageSender {

    void sendMessage(SendMessage message);

    void sendEditMessage(EditMessageText editMessageText);
}
