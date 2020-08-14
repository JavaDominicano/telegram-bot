package org.javadominicano.telegram.bot;

import org.telegram.telegrambots.bots.TelegramWebhookBot;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;

public class TestingHandlers extends TelegramWebhookBot {

  @Override
  public String getBotPath() {
    return "testing";
  }

  @Override
  public String getBotUsername() {
    return "JavaDominicanoBot";
  }

  @Override
  public String getBotToken() {
    return "1066275488:AAFb8tWGNEJtNb7L_glD9WvT5IpaSQKNwGg";
  }

  @Override
  public BotApiMethod<Message> onWebhookUpdateReceived(Update update) {
    System.out.println(update.getUpdateId());

    if (update.hasMessage() && update.getMessage()
        .hasText()) {
      // SendMessage sendMessage = new SendMessage();
      // sendMessage.setChatId(update.getMessage()
      // .getChatId()
      // .toString());
      // sendMessage.setText("Well, all information looks like noise until you break
      // the code.");
      // return sendMessage;
    }
    return null;
  }

}
