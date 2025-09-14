package com.weslaycodes.stockpile;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StockpileApplication {
    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(StockpileApplication.class);

        if (System.getProperty("spring.profiles.active") == null && System.getenv("SPRING_PROFILES_ACTIVE") == null) {
            app.setAdditionalProfiles("dev");
        }

        app.run(args);
    }
}
