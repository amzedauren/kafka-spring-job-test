package com.example.consumer.service;

import com.example.consumer.model.UserProfile;
import org.springframework.stereotype.Service;

@Service
public class RegisterServiceImpl {


    public void register(String userProfile) {
        // TODO
        System.out.println("RegisterServiceImpl register data: " + userProfile);
    }

}
