package org.javadominicano.telegram.bot;

import java.util.Set;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class Bot extends TelegramLongPollingBot {

    public Set<Handler> handlers;

    Bot(Set<Handler> handlers) {
        super();
        this.handlers = handlers;
    }

    public void addHadler(Handler handler) {
        this.handlers.add(handler);
    }

    public void setHandlers(Set<Handler> handlers) {
        this.handlers = handlers;
    }

    @Override
    public void onUpdateReceived(Update update) {
        for (Handler handler : handlers) {
            try{
                handler.onUpdateReceived(this, update);
            }catch (TelegramApiException e){
                e.printStackTrace();
            }
        }
    }

    @Override
    public String getBotUsername() {
        return "JavaDominicanoBot";
    }

    @Override
    public String getBotToken() {
        return "1066275488:AAFb8tWGNEJtNb7L_glD9WvT5IpaSQKNwGg";
    }

    public static interface Handler  {
        void onUpdateReceived(Bot bot, Update update) throws TelegramApiException;
    }
}