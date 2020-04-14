package com.example.rd.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * @Author: yl Created by IntelliJ IDEA
 * DateTime: 2020/4/14 13:46
 * version:
 * description:
 */
@Configuration
public class DirectExchangeConfig {

    public final static String QUEUE = "test_queue";

    /**
     * 如果没有队列会自动创建队列
     * direct 类型的行为是"先匹配, 再投送". 即在绑定时设定一个 routing_key, 消息的routing_key 匹配时,
     * 才会被交换器投送到绑定的队列中去.是RabbitMQ默认的交换机模式，也是最简单的模式，根据key全文匹配去寻找队列
     *
     * @return
     */
    @Bean
    public Queue queue() {
        return new Queue(QUEUE, true);
    }
}
