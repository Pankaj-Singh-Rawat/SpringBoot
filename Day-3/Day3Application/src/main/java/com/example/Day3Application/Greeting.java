package com.example.Day3Application;

import org.springframework.stereotype.Service;

@Service
public class Greeting{
    public String getGreeting(){
        return "I'm in Service Level.";
    }
}
