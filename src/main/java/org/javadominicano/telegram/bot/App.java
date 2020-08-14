package org.javadominicano.telegram.bot;

import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiRequestException;

public class App {
  public static void main(String[] args) {
    ApiContextInitializer.init();
    try {
      TelegramBotsApi telegramBotsApi = new TelegramBotsApi("https://02ad537898a5.ngrok.io", "http://localhost:38081");
      telegramBotsApi.registerBot(new TestingHandlers());
    } catch (TelegramApiRequestException e) {
      e.printStackTrace();
    }
  }
}
