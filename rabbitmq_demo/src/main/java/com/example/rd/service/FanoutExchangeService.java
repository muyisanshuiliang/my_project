package com.example.rd.service;

import com.example.rd.config.FanoutExchangeConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: yl Created by IntelliJ IDEA
 * DateTime: 2020/4/14 14:51
 * version:
 * description:
 */
@Slf4j
@Service
public class FanoutExchangeService {

    @Autowired
    private AmqpTemplate amqpTemplate;

    public void sendFanout(Object massage) {
        String msg = (String) massage;
        log.info("send fanout message: " + msg);
        amqpTemplate.convertAndSend(FanoutExchangeConfig.FANOUT_EXCHANGE, "", msg);
    }

    @RabbitListener(queues = FanoutExchangeConfig.FANOUT_QUEUE1)
    public void receiveFanout1(String msg) {
        log.info("receive fanout1 msg " + msg);
    }

    @RabbitListener(queues = FanoutExchangeConfig.FANOUT_QUEUE2)
    public void receiveFanout2(String msg) {
        log.info("receive fanout2 msg " + msg);
    }
}
