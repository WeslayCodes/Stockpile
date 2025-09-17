package com.weslaycodes.stockpile.commands;

import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;

public interface Subcommand {
    String getName();
    String getDescription();
    void execute(SlashCommandInteractionEvent event);
}
