package telegramBot.telegramBot;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import telegramBot.telegramBot.services.SendMessageService;
import org.telegram.telegrambots.meta.api.objects.Update;

class BotTest {

    private Bot bot;
    private SendMessageService sendMessageService;
    private Update update;

    @BeforeEach
    public void init() {
        update = new Update();
        bot = new Bot();
        sendMessageService = Mockito.mock(SendMessageService.class);
        bot.setSendMessageService(sendMessageService);
    }

    @Test
    public void shouldSendMessageOnUpdateReceived() {
        bot.onUpdateReceived(update);
        Mockito.verify(sendMessageService).send(update.getMessage());
    }
}