package com.example.rd.service;

import com.example.rd.config.DirectExchangeConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: yl Created by IntelliJ IDEA
 * DateTime: 2020/4/14 13:54
 * version:
 * description:
 */
@Slf4j
@Service
public class DirectExchangeService {

    @Autowired
    private AmqpTemplate amqpTemplate;


    public void sendDirectMessage(Object message) {
        String msg = (String) message;
        log.info("send msg" + message);
        amqpTemplate.convertAndSend(DirectExchangeConfig.QUEUE, msg);
    }

    /**
     * 监听队列
     * 消费的时候并不是按照发送顺序一致
     *
     * @param msg
     */
    @RabbitListener(queues = DirectExchangeConfig.QUEUE)
    public void receive(String msg) {
        log.info("receive msg " + msg);
    }


}
