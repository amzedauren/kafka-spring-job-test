package com.example.consumer.kafka;

import com.example.consumer.service.RegisterServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;

public class Receiver {

    private static final Logger LOGGER =
        LoggerFactory.getLogger(Receiver.class);

    @Autowired
    private RegisterServiceImpl registerService;


    @KafkaListener(topics = "register-new-user")
    public void receiveRegisterUser(String payload) {
        LOGGER.info("received payload='{}'", payload);

        // TODO
        this.registerService.register(payload);
    }

}