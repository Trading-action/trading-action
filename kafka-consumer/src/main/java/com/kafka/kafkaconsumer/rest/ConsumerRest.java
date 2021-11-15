package com.kafka.kafkaconsumer.rest;

import com.kafka.kafkaconsumer.bean.User;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class ConsumerRest {

    @KafkaListener(topics = "mytopic", groupId = "groupId")
    public void listenGroupFoo(User user) {
        System.out.println("************************************");
        System.out.println("Received Message in group foo: " + user.toString());
    }

}
