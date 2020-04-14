package com.example.rd;

import com.example.rd.service.DirectExchangeService;
import com.example.rd.service.FanoutExchangeService;
import com.example.rd.service.HeaderExchangeService;
import com.example.rd.service.TopicExchangeService;
import com.google.common.collect.Maps;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Map;

/**
 * @Author: yl Created by IntelliJ IDEA
 * DateTime: 2020/4/14 13:48
 * version:
 * description:
 */
@Slf4j
@SpringBootTest
public class TestSendServer {


    @Autowired
    private DirectExchangeService directExchangeService;

    @Autowired
    private TopicExchangeService topicExchangeService;

    @Autowired
    private HeaderExchangeService headerExchangeService;

    @Autowired
    private FanoutExchangeService fanoutExchangeService;

    @Test
    public void sendDirectExchangeMessage() {
        Map<Integer, String> message = Maps.newHashMap();
        message.put(1, "first Message");
        message.put(2, "second Message");
        message.put(3, "third Message");
        message.put(4, "forth Message");
        message.put(5, "fifth Message");
        for (Map.Entry<Integer, String> item : message.entrySet()) {
            directExchangeService.sendDirectMessage(item.getKey() + " == " + item.getValue());
        }
    }

    @Test
    public void sendTopicExchangeMessage() {
        Map<Integer, String> message = Maps.newHashMap();
        message.put(1, "first Message");
        message.put(2, "second Message");
        message.put(3, "third Message");
        message.put(4, "forth Message");
        message.put(5, "fifth Message");
        for (Map.Entry<Integer, String> item : message.entrySet()) {
            topicExchangeService.sendTopicMessage(item.getKey(), item.getKey() + " == " + item.getValue());
        }
    }

    @Test
    public void sendFanoutExchangeMessage() {
        Map<Integer, String> message = Maps.newHashMap();
        message.put(1, "first Message");
        message.put(2, "second Message");
        message.put(3, "third Message");
        message.put(4, "forth Message");
        message.put(5, "fifth Message");
        for (Map.Entry<Integer, String> item : message.entrySet()) {
            fanoutExchangeService.sendFanout(item.getKey() + " == " + item.getValue());
        }
    }

    @Test
    public void sendHeadersExchangeMessage() {
        Map<Integer, String> message = Maps.newHashMap();
        message.put(1, "first Message");
        message.put(2, "second Message");
        message.put(3, "third Message");
        message.put(4, "forth Message");
        message.put(5, "fifth Message");
        for (Map.Entry<Integer, String> item : message.entrySet()) {
            headerExchangeService.sendCorrectHeaders(item.getKey() + " == " + item.getValue());
        }
        for (Map.Entry<Integer, String> item : message.entrySet()) {
            headerExchangeService.sendErrorHeaders(item.getKey() + " == " + item.getValue());
        }
    }
}
