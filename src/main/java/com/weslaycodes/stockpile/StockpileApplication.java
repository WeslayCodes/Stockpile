package com.weslaycodes.stockpile;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StockpileApplication {
    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(StockpileApplication.class);

        Dotenv dotenv = Dotenv.load();
        dotenv.entries().forEach(e -> System.setProperty(e.getKey(), e.getValue()));

        if (System.getProperty("spring.profiles.active") == null && System.getenv("SPRING_PROFILES_ACTIVE") == null) {
            app.setAdditionalProfiles("dev");
        }

        app.run(args);
    }
}
