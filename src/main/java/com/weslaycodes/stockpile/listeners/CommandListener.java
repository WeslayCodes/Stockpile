package com.weslaycodes.stockpile.listeners;

import com.weslaycodes.stockpile.commands.Subcommand;
import jakarta.annotation.Nonnull;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class CommandListener extends ListenerAdapter {

    private final Map<String, Subcommand> subcommands;

    public CommandListener(List<Subcommand> subcommands) {
        this.subcommands = subcommands.stream()
            .collect(Collectors.toMap(Subcommand::getName, subcommand -> subcommand));
    }

    @Override
    public void onSlashCommandInteraction(@Nonnull SlashCommandInteractionEvent event) {
        Subcommand subcommand = this.subcommands.get(event.getSubcommandName());
        new Thread(() -> subcommand.execute(event)).start();
    }

}
