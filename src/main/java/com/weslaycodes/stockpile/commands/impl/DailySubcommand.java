package com.weslaycodes.stockpile.commands.impl;

import com.weslaycodes.stockpile.commands.Subcommand;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class DailySubcommand implements Subcommand {

    @Getter
    private final String name = "daily";

    @Getter
    private final String description = "Do your daily roll";

    @Override
    public void execute(SlashCommandInteractionEvent event) {
        log.info("Daily command executed!");
    }

}
