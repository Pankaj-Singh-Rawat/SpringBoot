package com.example.PracticeProject;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppController {
    private final AppConfig appConfig;

    public AppController(AppConfig appConfig) {
        this.appConfig = appConfig;
    }

    @GetMapping("/info")
    public String config() {
        return String.format("Name: %s | Version: %s | Owner: %s | Message: %s",
                appConfig.getName(),
                appConfig.getVersion(),
                appConfig.getOwner(),
                appConfig.getMessage());
    }

    @Value("${spring.profiles.active}")
    private String activeProfile;

    @GetMapping("/env")
    public String env(){
        return "User: " + activeProfile;
    }
}
