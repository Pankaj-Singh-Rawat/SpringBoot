package com.example.firstSmallProject;

import org.springframework.stereotype.Service;

@Service
public class Welcome {
    public String getWelcome(String name){
        if(name == null || name.isBlank()){
            return "Welcome! No-Name Guy.";
        }
        return "Welcome " + name + ".";
    }
}
