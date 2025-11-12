package com.example.firstSmallProject;

import org.springframework.stereotype.Service;

@Service
public class Goodbye {
    public String getGoodbye(String name){
        if(name == null || name.isBlank()){
            return "Goodbye No-Name Guy.";
        }
        return "Goodbye " + name + ".";
    }
}
