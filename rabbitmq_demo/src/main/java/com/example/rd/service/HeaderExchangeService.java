package com.example.rd.service;

import com.example.rd.config.HeadersExchangeConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: yl Created by IntelliJ IDEA
 * DateTime: 2020/4/14 15:01
 * version:
 * description:
 */
@Service
@Slf4j
public class HeaderExchangeService {

    @Autowired
    private AmqpTemplate amqpTemplate;

    public void sendCorrectHeaders(Object massage) {
        String msg = "correct message" + massage.toString();
        log.info("send correct headers message: " + msg);
        MessageProperties properties = new MessageProperties();
        properties.setHeader("header1", "value1");
        properties.setHeader("header2", "value2");
        Message obj = new Message(msg.getBytes(), properties);
        amqpTemplate.convertAndSend(HeadersExchangeConfig.HEADER_EXCHANGE, "", obj);
    }

    public void sendErrorHeaders(Object massage) {
        String msg = "error message" + massage.toString();
        log.info("send error headers message: " + msg);
        MessageProperties properties = new MessageProperties();
        properties.setHeader("header1", "value2");
        properties.setHeader("header2", "value1");
        Message obj = new Message(msg.getBytes(), properties);
        amqpTemplate.convertAndSend(HeadersExchangeConfig.HEADER_EXCHANGE, "", obj);
    }

    @RabbitListener(queues = HeadersExchangeConfig.HEADER_QUEUE)
    /**
     * 因为发送的是 byte 类型，所以接受也是该数据类型
     */
    public void receiveHeader(byte[] message) {
        log.info("header queue message " + new String(message));
    }


}
