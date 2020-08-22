package org.javadominicano.telegram.bot;

import java.util.Set;

import org.javadominicano.telegram.bot.Bot.Handler;
import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiRequestException;

public class BotInitializer {

	public static void init(Set<Handler> handlers) {
		try {
			ApiContextInitializer.init();
			TelegramBotsApi telegramBotsApi = new TelegramBotsApi();
			telegramBotsApi.registerBot(new Bot(handlers));
		} catch (TelegramApiRequestException e) {
			e.printStackTrace();
		}
	}
}
