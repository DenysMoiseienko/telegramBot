package telegramBot.telegramBot.handlers;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageText;
import org.telegram.telegrambots.meta.api.objects.CallbackQuery;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import telegramBot.telegramBot.messageSender.MessageSender;

import java.util.Collections;

@Component
public class CallbackQueryHandler implements Handler<CallbackQuery> {

    private final MessageSender messageSender;

    public CallbackQueryHandler(MessageSender messageSender) {
        this.messageSender = messageSender;
    }

    @Override
    public void choose(CallbackQuery callbackQuery) {
        if (callbackQuery.getData().equals("next_poem")) {
            String poemText = "І вам слава, сині гори,\n" +
                    "\n" +
                    "Кригою окуті.\n" +
                    "\n" +
                    "І вам, лицарі великі,\n" +
                    "\n" +
                    "Богом не забуті.\n" +
                    "\n" +
                    "Борітеся — поборете,\n" +
                    "\n" +
                    "Вам Бог помагає!\n" +
                    "\n" +
                    "За вас правда, за вас слава\n" +
                    "\n" +
                    "І воля святая!";
            Integer messageId = callbackQuery.getMessage().getMessageId();
            EditMessageText editMessageText = new EditMessageText();
            editMessageText.setChatId(String.valueOf(callbackQuery.getMessage().getChatId()));
            editMessageText.setMessageId(messageId);
            editMessageText.setText(poemText);
            editMessageText.setReplyMarkup(
                    InlineKeyboardMarkup.builder()
                            .keyboardRow(
                                    Collections.singletonList(
                                            InlineKeyboardButton.builder()
                                                    .text("Посилання")
                                                    .url("http://litopys.org.ua/shevchenko/shev139.htm")
                                                    .build()
                                    )).build());
            messageSender.sendEditMessage(editMessageText);
        }
    }
}