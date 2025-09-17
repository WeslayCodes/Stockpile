package com.weslaycodes.stockpile.listeners;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ListenerInitializer {

    private final JDA jda;
    private final List<ListenerAdapter> listeners;

    @PostConstruct
    public void initListeners() {
        listeners.forEach(jda::addEventListener);
    }

}
