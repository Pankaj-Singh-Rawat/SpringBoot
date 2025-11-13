package com.example.firstSmallProject;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {
    private final Welcome welcomeService;

    public WelcomeController(Welcome welcome){
        this.welcomeService = welcome;
    }

    @GetMapping("/welcome")
    public String welcome(@RequestParam(required = false) String name){
        return welcomeService.getWelcome(name);
    }
}
