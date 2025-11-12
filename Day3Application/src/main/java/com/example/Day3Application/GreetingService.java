package com.example.Day3Application;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingService {
    private final Greeting greetingService;

    public GreetingService(Greeting greeting){
        this.greetingService = greeting;
    }

    @GetMapping("/greet")
    public String greet(){
        return greetingService.getGreeting();
    }
}
