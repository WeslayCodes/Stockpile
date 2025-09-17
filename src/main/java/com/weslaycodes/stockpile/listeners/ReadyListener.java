package com.weslaycodes.stockpile.listeners;

import com.weslaycodes.stockpile.services.CommandService;
import jakarta.annotation.Nonnull;
import lombok.extern.slf4j.Slf4j;
import net.dv8tion.jda.api.events.session.ReadyEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class ReadyListener extends ListenerAdapter {

    private final CommandService commandUpdateService;

    public ReadyListener(CommandService commandUpdateService) {
        super();
        this.commandUpdateService = commandUpdateService;
    }

    @Override
    public void onReady(@Nonnull ReadyEvent event) {
        log.info("Bot online!");
        commandUpdateService.updateCommands();
    }

}
