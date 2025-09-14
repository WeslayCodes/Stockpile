package com.weslaycodes.stockpile.listeners;

import jakarta.annotation.Nonnull;
import lombok.extern.slf4j.Slf4j;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class MessageListener extends ListenerAdapter {

    @Override
    public void onMessageReceived(@Nonnull MessageReceivedEvent event) {
        log.info("hi");
    }
}
