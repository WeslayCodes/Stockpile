package com.weslaycodes.stockpile.listeners;

import jakarta.annotation.Nonnull;
import lombok.extern.slf4j.Slf4j;
import net.dv8tion.jda.api.events.session.ReadyEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class ReadyListener extends ListenerAdapter {

    @Override
    public void onReady(@Nonnull ReadyEvent event) {
        log.info("Bot online!");
    }
}
