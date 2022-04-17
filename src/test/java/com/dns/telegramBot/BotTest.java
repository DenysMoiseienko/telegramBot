package com.dns.telegramBot;

import com.dns.telegramBot.services.SendMessageService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

import static org.mockito.Mockito.*;

class BotTest {

    private Bot bot;
    private SendMessageService sendMessageService;
    private Update update;

    @BeforeEach
    public void init() {
        update = mock(Update.class);
        sendMessageService = mock(SendMessageService.class);
        bot = new Bot(sendMessageService);
    }

    @Test
    public void shouldSendMessageOnUpdateReceived() {
        // given
        var sm = createTestSendMessage();
        when(sendMessageService.send(any())).thenReturn(sm);

        // when
        bot.onUpdateReceived(update);

        // then
        verify(sendMessageService, times(1)).send(update.getMessage());
    }

    private SendMessage createTestSendMessage() {
        return SendMessage.builder()
                .text("Test")
                .parseMode("HTML")
                .chatId("10000000000")
                .build();
    }
}