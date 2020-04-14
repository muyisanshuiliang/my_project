package com.example.rd.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: yl Created by IntelliJ IDEA
 * DateTime: 2020/4/14 14:25
 * version:
 * description:
 */
@Configuration
public class TopicExchangeConfig {

    public static final String TOPIC_QUEUE1 = "topic.queue1";
    public static final String TOPIC_QUEUE2 = "topic.queue2";
    public static final String ROUTING_KEY1 = "topic.key1";
    public static final String ROUTING_KEY2 = "topic.#";
    public static final String TOPIC_EXCHANGE = "test_exchange";

    /**
     * Topic 交换机模式  可以用通配符
     * 按规则转发消息（最灵活） 转发消息主要是根据通配符。 在这种交换机下，队列和交换机的绑定会定义一种路由模式，
     * 那么，通配符就要在这种路由模式和路由键之间匹配后交换机才能转发消息。
     * 路由键必须是一串字符，用句号（.） 隔开，
     * 路由模式必须包含一个 星号（*），主要用于匹配路由键指定位置的一个单词， 井号（#）就表示相当于一个或者多个单词
     */
    @Bean
    public Queue topicQueue1() {
        return new Queue(TOPIC_QUEUE1, true);
    }

    @Bean
    public Queue topicQueue2() {
        return new Queue(TOPIC_QUEUE2, true);
    }

    @Bean
    public TopicExchange topicExchange() {
        return new TopicExchange(TOPIC_EXCHANGE);
    }

    @Bean
    public Binding topicBinding1() {
        return BindingBuilder.bind(topicQueue1()).to(topicExchange()).with(ROUTING_KEY1);
    }

    @Bean
    public Binding topicBinding2() {
        return BindingBuilder.bind(topicQueue2()).to(topicExchange()).with(ROUTING_KEY2);
    }

}
