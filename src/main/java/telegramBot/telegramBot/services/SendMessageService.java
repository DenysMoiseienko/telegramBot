package telegramBot.telegramBot.services;

import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
import telegramBot.telegramBot.messageSender.MessageSender;

import java.util.ArrayList;
import java.util.List;

@Service
public class SendMessageService {

    private final MessageSender messageSender;

    public SendMessageService(MessageSender messageSender) {
        this.messageSender = messageSender;
    }

    public void test(Message message) {
        SendMessage sm = SendMessage.builder()
                .text("<b>Bold</b> " +
                        "<i>italic</i>" +
                        " <code>mono</code> " +
                        "<a href=\"google.com\">Google</a>")
                .parseMode("HTML")
                .chatId(String.valueOf(message.getChatId()))
                .build();

        messageSender.sendMessage(sm);
    }

    public void test2(Message message) {
        ReplyKeyboardMarkup markup = new ReplyKeyboardMarkup();
        List<KeyboardRow> keyboardRows = new ArrayList<>();

        KeyboardRow row1 = new KeyboardRow();
        KeyboardRow row2 = new KeyboardRow();
        KeyboardRow row3 = new KeyboardRow();

        row1.add("Button 1");
        row1.add("Button 2");
        row1.add("Button 3");
        row2.add(KeyboardButton.builder().text("Phone Number")
                .requestContact(true)
                .build());
        row3.add(KeyboardButton.builder()
                .requestLocation(true)
                .text("Location")
                .build());

        keyboardRows.add(row1);
        keyboardRows.add(row2);
        keyboardRows.add(row3);

        markup.setKeyboard(keyboardRows);
        markup.setResizeKeyboard(true);

        SendMessage sm = SendMessage.builder()
                .text("Test")
                .chatId(String.valueOf(message.getChatId()))
                .replyMarkup(markup)
                .build();

        messageSender.sendMessage(sm);
    }
}