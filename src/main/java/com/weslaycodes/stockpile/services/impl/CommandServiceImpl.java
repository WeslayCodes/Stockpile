package com.weslaycodes.stockpile.services.impl;

import com.weslaycodes.stockpile.commands.Subcommand;
import com.weslaycodes.stockpile.config.BotConfig;
import com.weslaycodes.stockpile.services.CommandService;
import lombok.extern.slf4j.Slf4j;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.interactions.commands.build.Commands;
import net.dv8tion.jda.api.interactions.commands.build.SubcommandData;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class CommandServiceImpl implements CommandService {

    private final JDA jda;
    private final BotConfig botConfig;
    private final List<Subcommand> subcommands;

    public CommandServiceImpl(JDA jda, BotConfig botConfig, List<Subcommand> subcommands) {
        this.jda = jda;
        this.botConfig = botConfig;
        this.subcommands = subcommands;
    }

    public void updateCommands() {
        List<SubcommandData> subcommandDataList = subcommands.stream()
            .map(subcommand -> new SubcommandData(subcommand.getName(), subcommand.getDescription()))
            .toList();
        String commandDescription = String.format("Commands to interact with %s", botConfig.getBotName());

        jda.updateCommands()
            .addCommands(Commands.slash(botConfig.getCommandName(), commandDescription)
                .addSubcommands(subcommandDataList))
            .queue(
                command -> log.info("Successfully updated commands"),
                e -> log.warn("Failed to update commands", e)
            );
    }
}
