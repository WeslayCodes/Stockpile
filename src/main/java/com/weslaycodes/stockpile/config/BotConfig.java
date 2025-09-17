package com.weslaycodes.stockpile.config;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.requests.GatewayIntent;
import net.dv8tion.jda.api.utils.MemberCachePolicy;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
public class BotConfig {

    @Getter
    @Value("${bot.commandName}")
    private String commandName;

    @Getter
    @Value("${bot.name}")
    private String botName;

    @Bean
    public JDA buildJda(@Value("${bot.token}") String token, @Value("${bot.status}") String botStatus) {
        return JDABuilder.createDefault(token)
            .setActivity(Activity.customStatus(botStatus))
            .setAutoReconnect(true)
            .setEnabledIntents(
                GatewayIntent.GUILD_MEMBERS,
                GatewayIntent.GUILD_VOICE_STATES,
                GatewayIntent.SCHEDULED_EVENTS,
                GatewayIntent.GUILD_EXPRESSIONS,
                GatewayIntent.GUILD_MESSAGES,
                GatewayIntent.DIRECT_MESSAGES
            )
            .setMemberCachePolicy(MemberCachePolicy.ALL)
            .build();
    }

}
