package com.example.mtd.service;

import com.example.mtd.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: yl Created by IntelliJ IDEA
 * DateTime: 2020/4/7 15:59
 * version:
 * description:
 */
@Service("studentService")
public class StudentService {

    @Autowired
    private MongoTemplate mongoTemplate;

    public List<Student> getAll() {
        return mongoTemplate.findAll(Student.class, "my-test");
    }

    public void save(Student student) {
        Student save = mongoTemplate.save(student, "my-test");
        System.out.println(save);
    }

    public void batchSave(List<Student> students){
        mongoTemplate.insertAll(students);
    }

}
