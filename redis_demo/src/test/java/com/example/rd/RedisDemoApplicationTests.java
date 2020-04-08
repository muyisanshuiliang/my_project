package com.example.rd;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

@SpringBootTest
public class RedisDemoApplicationTests {

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @Test
    public void contextLoads() {
        String stringValue;
        redisTemplate.opsForValue().set("1", "张三");
        stringValue = redisTemplate.opsForValue().get("1");
        System.out.println("通过get(Object key)方法获取set(K key, V value)方法新增的字符串值：" + stringValue);
        /*在原有的值基础上新增字符串到末尾*/
        redisTemplate.opsForValue().append("1", "aaa");
        String stringValueAppend = redisTemplate.opsForValue().get("1");
        System.out.println("通过append(K key, String value)方法修改后的字符串：" + stringValueAppend);
        String cutString = redisTemplate.opsForValue().get("1", 0, 4);
        System.out.println("通过get(K key, long start, long end)方法获取截取的字符串：" + cutString);

        String oldAndNewStringValue = redisTemplate.opsForValue().getAndSet("1","ccc")+"";
        System.out.print("通过getAndSet(K key, V value)方法获取原来的" + oldAndNewStringValue + ",");
        String newStringValue = redisTemplate.opsForValue().get("1")+"";
        System.out.println("修改过后的值:"+newStringValue);

    }

}
