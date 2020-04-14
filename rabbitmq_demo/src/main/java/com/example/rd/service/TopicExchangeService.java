package com.example.rd.service;

import com.example.rd.config.TopicExchangeConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: yl Created by IntelliJ IDEA
 * DateTime: 2020/4/14 14:31
 * version:
 * description:
 */
@Service
@Slf4j
public class TopicExchangeService {
    @Autowired
    private AmqpTemplate amqpTemplate;

    public void sendTopicMessage(int number, Object message) {
        String msg = (String) message;
        log.info("send topic message" + msg);
        if (number % 2 == 0) {
            amqpTemplate.convertAndSend(TopicExchangeConfig.TOPIC_EXCHANGE, "topic.key2", msg + number);
        } else {
            amqpTemplate.convertAndSend(TopicExchangeConfig.TOPIC_EXCHANGE, "topic.key1", msg + number);
        }
    }

    @RabbitListener(queues = TopicExchangeConfig.TOPIC_QUEUE1)
    public void receiveTopic1(String msg) {
        log.info("receive topic1 msg " + msg);
    }

    @RabbitListener(queues = TopicExchangeConfig.TOPIC_QUEUE2)
    public void receiveTopic2(String msg) {
        log.info("receive topic2 msg " + msg);
    }

}
