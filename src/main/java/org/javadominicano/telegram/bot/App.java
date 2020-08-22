package org.javadominicano.telegram.bot;

import java.util.Set;

import org.javadominicano.telegram.bot.handler.register.RegisterHandler;

public class App {
	public static void main(String[] args) {
		BotInitializer.init(Set.of(
			new RegisterHandler()
		));
	}
}