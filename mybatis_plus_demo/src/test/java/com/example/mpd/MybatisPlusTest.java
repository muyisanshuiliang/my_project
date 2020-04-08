package com.example.mpd;


import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.mpd.enums.SexEnum;
import com.example.mpd.mapper.UserMapper;
import com.example.mpd.model.User;
import com.example.mpd.service.UserService;
import com.google.common.collect.Lists;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.DecimalFormat;
import java.util.List;

/**
 * @Author yl
 * @Date 2019/12/16 14:17
 * @description:
 */
@SpringBootTest
public class MybatisPlusTest {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserService userService;

    @Test
    void testInsert() {
        User user = new User();
        user.setAddress("四川省成都市");
        user.setName("张三1");
        userMapper.insert(user);
    }

    @Test
    void batchTest() {
        List<User> users = Lists.newArrayList();
        User user;
        JSONObject jsonObject;
        for (int i = 0; i < 5; i++) {
            user = new User();
            String format = new DecimalFormat("00000").format(i);
            user.setAddress("四川省成都市" + format);
            user.setName("张三" + format);
            jsonObject = new JSONObject();
            user.setSex(SexEnum.getSexEnum((i % 3 == 0) ? 1 : 2));
            jsonObject.put("father", new StringBuilder(user.getName()).append("'s father"));
            jsonObject.put("mother", new StringBuilder(user.getName()).append("'s mother"));
            jsonObject.put("son", new StringBuilder(user.getName()).append("'s son"));
            user.setDetailInfo(jsonObject);
            users.add(user);
        }
        userService.saveBatch(users, 50);
    }

    @Test
    void testInsert1() {
        User user = new User();
        user.setAddress("四川省成都市");
        user.setName("张三1");
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("father", "zhangsan's father");
        jsonObject.put("mother", "zhangsan's mother");
        jsonObject.put("son", "zhangsan's son");
        user.setDetailInfo(jsonObject);
        userMapper.insert(user);
    }


    @Test
    void testUpdate1() {
        User user = new User();
//        user.setAddress("四川省成都市111122222");
        user.setName("张三3");
        user.setStudentNumber(4);
        userMapper.updateById(user);
    }

    //
//    @Test
//    void testUpdate2() {
//        User user = new User();
//        user.setId(2);
//        user.setNumber(2019002);
//        userMapper.updateById(user);
//    }
//
    @Test
    void get() {
        User user = userMapper.selectById(201227);
        System.out.println(user);
    }

    @Test
    public void getPageList() {
        Page<User> userPage = userMapper.selectPage(new Page<>(1, 10), new QueryWrapper<User>().orderByDesc("student_number"));
        List<User> records = userPage.getRecords();
        System.out.println(userPage.getCurrent() + " ========= " + userPage.getTotal() + " ========= " + userPage.getSize() + " ========= " + userPage.getPages() + " ========= " + userPage.getOrders());
        if (records != null && records.size() != 0) {
            records.forEach(item -> System.out.println(item));
        }
    }

    @Test
    void deleteAll() {
        int i = userMapper.deleteAll();
        System.out.println("影响行数：" + i);
    }

    @Test
    public void testLogicDelete(){
        userMapper.deleteById(201228);
    }
}
