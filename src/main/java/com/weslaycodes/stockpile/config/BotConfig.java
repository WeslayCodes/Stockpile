package com.weslaycodes.stockpile.config;

import lombok.extern.slf4j.Slf4j;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.requests.GatewayIntent;
import net.dv8tion.jda.api.utils.MemberCachePolicy;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
@Slf4j
public class BotConfig {

    private final List<ListenerAdapter> listeners;

    private final ConfigurationConfig config;

    public BotConfig(List<ListenerAdapter> listeners, ConfigurationConfig config) {
        this.listeners = listeners;
        this.config = config;
    }

    @Bean
    public JDA jda(@Value("${bot.token}") String token) {
        return JDABuilder.createDefault(token)
            .addEventListeners(listeners.toArray(new Object[0]))
            .setActivity(Activity.customStatus(config.botStatus()))
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
