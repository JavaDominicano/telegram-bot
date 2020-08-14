package org.javadominicano.telegram.bot;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class ChannelHandlers extends TelegramLongPollingBot {

  @Override
  public void onUpdateReceived(Update update) {
    System.out.println("hola");
    if (update.hasMessage() && update.getMessage()
        .hasText()) {
      SendMessage message = new SendMessage();
      message.setChatId(update.getMessage()
          .getChatId());
      message.setText(update.getMessage()
          .getText());

      try {
        execute(message);
      } catch (TelegramApiException e) {
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
}
