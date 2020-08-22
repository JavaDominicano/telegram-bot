package org.javadominicano.telegram.bot.handler;

import org.javadominicano.telegram.bot.Bot;
import org.javadominicano.telegram.bot.Bot.Handler;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class ExampleHandler implements Handler {

    @Override
    public void onUpdateReceived(Bot bot, Update update) throws TelegramApiException {
        if (update.hasMessage() && update.getMessage().hasText()) {
        
            SendMessage sendMessage = new SendMessage()
                .setChatId(update.getMessage().getChatId())
                .setText(update.getMessage().getText());

            bot.execute(sendMessage);
        }
    }
}