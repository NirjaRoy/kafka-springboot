package com.kafka.consumerProducer.controller;

import com.kafka.consumerProducer.service.Producer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/kafka")
public class KafkaController {

    @Autowired
    Producer producer;

    @PostMapping(value="/topic1")
    public void SendMessgae1(@RequestParam("message") String message){
        producer.publishToTopic1(message);
    }

    @PostMapping(value="/topic2")
    public void SendMessgae2(@RequestParam("message") String message){
        producer.publishToTopic2WithCallback(message);
    }
}


