package com.example.producer.controller;

import java.util.concurrent.atomic.AtomicLong;

import com.example.producer.kafka.MessageProducer;
import com.example.producer.model.UserProfile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegisterController {

    private final AtomicLong counter = new AtomicLong();

    @Autowired MessageProducer messageProducer;

    @GetMapping("/register")
    public UserProfile greeting(@RequestParam(value = "name", defaultValue = "") String fullName,
                                @RequestParam(value = "age", defaultValue = "0") int age,
                                @RequestParam(value = "email", defaultValue = "") String email) {
        var userProfile = new UserProfile(counter.incrementAndGet(), fullName, age, email);
        this.messageProducer.sendMessage(userProfile);
        return userProfile;
    }

    @GetMapping("/ping")
    public String ping() {
        return "pong";
    }

}