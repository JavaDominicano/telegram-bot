# Telegram Bot Demo

See BotFather: https://t.me/botfather. Command /help throws details.
More documentation about telegram-bots library in the fallowing link: https://github.com/rubenlagus/TelegramBots

New features should be added using an implementation of the ```org.javadominicano.telegram.bot.Bot.Handler``` interface as below:

```
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
```

The main class( ```App.java```) has a initilizer method "init" of BotInitilizer class, in the same package. The init method receive a set of implementations of the ```org.javadominicano.telegram.bot.Bot.Handler``` interface, where you should place your implementation.

## How to run the jar?

Run the main class (```App.java```) in maven
```
mvn exec:java -Dexec.mainClass="org.javadominicano.telegram.bot.App"
```

Also, you can compile the app and run the resulting jar in the target folder

```
BotInitializer.init(Set.of(
    new RegisterHandler(), 
    new ExampleHandler()
));
```

### Notes:
As a nomenclature **proposal**, try to use the **YourClasName**Handler for your handler classes, to keep the code as uniform as possible.
