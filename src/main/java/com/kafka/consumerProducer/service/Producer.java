package com.kafka.consumerProducer.service;

import org.hibernate.sql.Template;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

@Service
public class Producer {
    public static final String topic1 = "Topic1";
    public static final String topic2 = "Topic2";
    Logger log = LoggerFactory.getLogger(Producer.class);

    @Autowired
    private KafkaTemplate<String,String> kafkaTemp;

    public void publishToTopic1(String message){
        log.info("Publishing to topic- "+topic1);
        this.kafkaTemp.send(topic1,message);
    }

    public void publishToTopic2WithCallback(String message) {
        ListenableFuture<SendResult<String, String>> future =
                kafkaTemp.send(topic2, message);

        future.addCallback(new ListenableFutureCallback<SendResult<String, String>>() {
            @Override
            public void onSuccess(SendResult<String, String> result) {
                log.info("Message '{}' published to topic '{}' with offset {}",
                        message,topic2, result.getRecordMetadata().offset());
            }

            @Override
            public void onFailure(Throwable ex) {
                log.warn("Unable to publish message '{}' to topic '{}'. {}",
                        message,topic2, ex.getMessage());
            }
        });
    }
}
