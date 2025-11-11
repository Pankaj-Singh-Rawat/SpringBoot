package com.example.firstWebApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalTime;

@SpringBootApplication
@RestController
public class FirstWebAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(FirstWebAppApplication.class, args);
    }

    @GetMapping("/hello")
    public String hello() {
        return "Hello Pankaj";
    }

    @GetMapping("/time")
    public String time() {
        return LocalTime.now().toString();
    }
}
