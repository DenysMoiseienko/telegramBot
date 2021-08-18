package telegramBot.telegramBot;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;
import telegramBot.telegramBot.services.SendMessageService;
import org.telegram.telegrambots.meta.api.objects.Update;

class BotTest {

    private Bot bot;
    private SendMessageService sendMessageService;
    private Update update;

    @BeforeEach
    public void init() {
        update = mock(Update.class);
        sendMessageService = mock(SendMessageService.class);
        bot = new Bot();
        bot.setSendMessageService(sendMessageService);
    }

    @Test
    public void shouldSendMessageOnUpdateReceived() {
        bot.onUpdateReceived(update);
        verify(sendMessageService).send(update.getMessage());
    }
}