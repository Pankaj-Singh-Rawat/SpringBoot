package com.example.firstSmallProject;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GoodbyeController {
    private final Goodbye goodbyeService;

    public GoodbyeController(Goodbye goodbye){
        this.goodbyeService = goodbye;
    }

    @GetMapping("/goodbye")
    public String goodbye(@RequestParam(required = false) String name){
        return goodbyeService.getGoodbye(name);
    }

}
