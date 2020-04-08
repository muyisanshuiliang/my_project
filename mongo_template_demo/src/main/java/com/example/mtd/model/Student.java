package com.example.mtd.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author: yl Created by IntelliJ IDEA
 * DateTime: 2020/4/7 10:10
 * version:
 * description:
 */
@Data
@Document(collection = "my-test")
public class Student implements Serializable {

    @Id
    private String id;

    /**
     * 学生id
     **/
    @Field(value = "student_id")
    private Integer studentId;

    /**
     * 学生姓名
     **/
    @Field(value = "student_name")
    private String studentName;

    /**
     * 学校id
     **/
    @Field(value = "age")
    private Integer age;

    /**
     * 测试时间
     **/
    @Field(value = "test_time")
    private Date testTime;

}
