package telegramBot.telegramBot.messageSender;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import telegramBot.telegramBot.Bot;

class MessageSenderTest {

    private MessageSender messageSender;
    private Bot bot;

    @BeforeEach
    public void init() {
        bot = mock(Bot.class);
        messageSender = new MessageSenderImpl(bot);
    }

    @Test
    public void shouldProperlySendMessage() throws TelegramApiException {
        Long chatId = 123L;
        String message = "test_message";

        SendMessage sm = SendMessage.builder()
                .text(message)
                .parseMode("HTML")
                .chatId(String.valueOf(chatId))
                .build();

        messageSender.sendMessage(sm);

        verify(bot).execute(sm);
    }
}