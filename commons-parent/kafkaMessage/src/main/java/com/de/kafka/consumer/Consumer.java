package com.de.kafka.consumer;


import com.de.kafka.constant.TopicConstant;
import com.de.kafka.entity.Message;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 *
 * @author jensen
 * @description  消息消费者者用于处理消息
 * @date 2018/5/3 0:22
 */
@Component
public class Consumer {

    private Gson gson = new GsonBuilder().create();

    @KafkaListener(topics = TopicConstant.TOPIC)
    public void onMessage(String payMessage) {
        Message msg = gson.fromJson(payMessage, Message.class);
        System.out.println("MessageConsumer: onMessage: message is: [" + msg + "]");
    }
}