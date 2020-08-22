package org.javadominicano.telegram.bot.handler.register;

import org.javadominicano.telegram.bot.Bot;
import org.javadominicano.telegram.bot.Bot.Handler;
import org.telegram.telegrambots.meta.api.methods.groupadministration.KickChatMember;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import io.jsondb.JsonDBTemplate;

public class RegisterHandler implements Handler {

    static final String REGISTRATION_KEY = "hola hola";
    static final String ALREADY_REGISTERED = "Muy bien @%s! Ya has sido registrado, bienvenido!";
    static final String HOW_REGISTER = "Hola @%s! Para registrarte como NO Spam, envia un mensaje que contenga: "
            + RegisterHandler.REGISTRATION_KEY;

    JsonDBTemplate jsonDBTemplate;

    public RegisterHandler() {
        String dbFilesLocation = "data/contacts.json";
        String baseScanPackage = "org.javadominicano.telegram.bot.handler.register";
        jsonDBTemplate = new JsonDBTemplate(dbFilesLocation, baseScanPackage);
        if (!jsonDBTemplate.collectionExists(Contact.class)) {
            jsonDBTemplate.createCollection(Contact.class);
        }
    }

    @Override
    public void onUpdateReceived(final Bot bot, final Update update) throws TelegramApiException {
        if (update.hasMessage() && update.getMessage().hasText()) {

            String username = update.getMessage().getFrom().getUserName();
            if (username == null)
                username = update.getMessage().getFrom().getFirstName();

            Contact contact = new Contact(username);

            if (jsonDBTemplate.findById(username, Contact.class) == null) {

                final SendMessage sendMessage = new SendMessage().setChatId(update.getMessage().getChatId())
                        .setText(String.format(HOW_REGISTER, username));

                bot.execute(sendMessage);

                contact.setTemporal(true);
                jsonDBTemplate.upsert(contact);

            } else if (update.getMessage().getText().toLowerCase().contains(REGISTRATION_KEY)) {

                final SendMessage sendMessage = new SendMessage().setChatId(update.getMessage().getChatId())
                        .setText(String.format(ALREADY_REGISTERED, username));

                bot.execute(sendMessage);

                contact.setTemporal(false);
                jsonDBTemplate.upsert(contact);

            } else if (jsonDBTemplate.findById(username, Contact.class).isTemporal()) {

                final KickChatMember kickChatMember = new KickChatMember(update.getMessage().getChatId(),
                        update.getMessage().getFrom().getId());

                bot.execute(kickChatMember);

                jsonDBTemplate.remove(contact, Contact.class);
            }
        }
    }

}