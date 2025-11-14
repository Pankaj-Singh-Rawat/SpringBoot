package com.example.Day4;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConfigController {

//    Accessing application.properties:

//    @Value("${spring.application.name}")
//    private String appName;
//
//    @Value("${spring.owner.name}")
//    private String ownerName;
//
//    @GetMapping("/config")
//    public String config(){
//        return "App: " + appName + " | Owner: " + ownerName;
    @Value("${spring.application.name}")
    private String appName;
    //    Accessing application.yml
    private final AppConfig appConfig;

    public ConfigController(AppConfig appConfig) {
        this.appConfig = appConfig;
    }

    @GetMapping("/config")
    public String config() {
        return String.format("Environment App Name: %s | Config Name: %s | Owner: %s | Version: %s",
                appName,
                appConfig.getName(),
                appConfig.getOwner(),
                appConfig.getVersion());
    }
}

