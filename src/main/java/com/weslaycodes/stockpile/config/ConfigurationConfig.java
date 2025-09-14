package com.weslaycodes.stockpile.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigurationConfig {

    @Value("${bot.status}")
    private String botStatus;

    @Bean
    public String botStatus() { return botStatus; }

}
