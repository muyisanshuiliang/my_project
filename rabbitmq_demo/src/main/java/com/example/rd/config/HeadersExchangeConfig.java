package com.example.rd.config;

import com.google.common.collect.Maps;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.HeadersExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

/**
 * @Author: yl Created by IntelliJ IDEA
 * DateTime: 2020/4/14 14:59
 * version:
 * description:
 */
@Configuration
public class HeadersExchangeConfig {

    public static final String HEADER_EXCHANGE = "header_exchange";
    public static final String HEADER_QUEUE = "header_queue";

    /**
     * Header 交换机模式
     * 设置header attribute参数类型的交换机，相较于 direct 和 topic 固定地使用 routing_key ,
     * headers 则是一个自定义匹配规则的类型. 在队列与交换器绑定时, 会设定一组键值对规则, 消息中也包括一组键值对( headers 属性),
     * 当这些键值对有一对, 或全部匹配时, 消息被投送到对应队列
     */
    @Bean
    public HeadersExchange headersExchange() {
        return new HeadersExchange(HEADER_EXCHANGE);
    }

    @Bean
    public Queue headerQueue() {
        return new Queue(HEADER_QUEUE, true);
    }

    /**
     * 绑定需要指定header，如果不匹配 则不能使用
     *
     * @return
     */
    @Bean
    public Binding headerBinding() {
        Map<String, Object> map = Maps.newHashMap();
        map.put("header1", "value1");
        map.put("header2", "value2");
        return BindingBuilder.bind(headerQueue()).to(headersExchange()).whereAll(map).match();
    }

}
