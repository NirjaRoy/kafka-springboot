package com.kafka.consumerProducer.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class Consumer {
    Logger log = LoggerFactory.getLogger(Producer.class);

    @KafkaListener(topics="Topic1",groupId = "mygroup")
    public void consumeFromTopic(String message){
        log.info("Consumed message- "+message);
    }

    @KafkaListener(topics="Topic2",groupId = "mygroup")
    public void consumeFromTopic2(String message){
        log.info("Consumed message2- "+message);
    }
}
