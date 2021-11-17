package com.kafka.consumerProducer.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class Consumer {
    @KafkaListener(topics="myTopic",groupId = "mygroup")
    public void consumeFromTopic(String message){
        System.out.println("Consumed message- "+message);
    }
}
