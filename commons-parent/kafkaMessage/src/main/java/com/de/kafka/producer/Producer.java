package com.de.kafka.producer;


import com.de.kafka.constant.TopicConstant;
import com.de.kafka.entity.Message;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.apache.kafka.clients.producer.RecordMetadata;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.ProducerListener;
import org.springframework.stereotype.Component;

/**
 *
 * @author jensen
 * @description  消息生产者用于发送消息
 * @date 2018/5/3 0:16
 */
@Component
public class Producer {

    @Autowired
    private KafkaTemplate kafkaTemplate;
    private Gson gson = new GsonBuilder().create();

    public void send(Message payMessage) {
        String msg = gson.toJson(payMessage);
        kafkaTemplate.send(TopicConstant.TOPIC, msg);
        System.out.println("MessageProducer: send: message is: [" + msg + "]");

        //消息发送的监听器，用于回调返回信息
        kafkaTemplate.setProducerListener(new ProducerListener<String, String>() {
            @Override
            public void onSuccess(String topic, Integer partition, String key, String value, RecordMetadata recordMetadata) {
            }

            @Override
            public void onError(String topic, Integer partition, String key, String value, Exception exception) {
            }

            @Override
            public boolean isInterestedInSuccess() {
                System.out.println("信息发送完毕");
                return false;
            }
        });

    }

}