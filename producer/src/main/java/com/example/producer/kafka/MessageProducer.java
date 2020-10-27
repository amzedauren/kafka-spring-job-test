package com.example.producer.kafka;

import com.example.producer.model.UserProfile;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

@Slf4j
@NoArgsConstructor
@Component
public class MessageProducer {

    @Autowired
    private KafkaTemplate<String, UserProfile> kafkaTemplate;

    @Value(value = "${kafka.topic.name}")
    private String topicName;


    public void sendMessage(UserProfile data) {
        ListenableFuture<SendResult<String, UserProfile>> future = kafkaTemplate.send(topicName, data);

        future.addCallback(new ListenableFutureCallback<>() {
            @Override
            public void onFailure(Throwable throwable) {
                log.error("Unable to send message = {} dut to: {}", data, throwable.getMessage());
            }

            @Override
            public void onSuccess(SendResult<String, UserProfile> stringDataSendResult) {
                log.info("Sent Message = {} with offset = {}", data, stringDataSendResult.getRecordMetadata().offset());
            }
        });
    }
}