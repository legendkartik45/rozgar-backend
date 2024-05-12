package com.backend.rozgar.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Demo {
    @GetMapping("/home")
    public String home(){
        return "Hi Home";
    }
}
