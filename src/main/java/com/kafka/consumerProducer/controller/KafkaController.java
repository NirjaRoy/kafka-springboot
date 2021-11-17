package com.kafka.consumerProducer.controller;

import com.kafka.consumerProducer.service.Producer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class KafkaController {

    @Autowired
    Producer producer;

    @PostMapping(value="/post")
    public void SendMessgae(@RequestParam("message") String message){
        producer.publishToTopic(message);
    }

}
