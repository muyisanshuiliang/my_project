package com.example.mtd;

import com.example.mtd.model.Student;
import com.example.mtd.service.StudentService;
import com.google.common.collect.Lists;
import com.mongodb.BasicDBObject;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.aggregation.GroupOperation;
import org.springframework.data.mongodb.core.aggregation.SortOperation;

import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

@SpringBootTest
public class MongoTemplateDemoApplicationTests {


    @Autowired
    private StudentService studentService;

    @Autowired
    private MongoTemplate mongoTemplate;

    @Test
    public void contextLoads() {

        System.out.println(studentService.getAll());
//        String start = "2020-04-03 16:22";
//        String stop = "2020-04-03 16:30";
//        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
//        Integer irriMouthId = 408;
//        LocalDateTime startTime = LocalDateTime.parse(start, dateTimeFormatter);
//        int minute = startTime.getMinute();
//        startTime = startTime.minusMinutes(minute);
//        LocalDateTime stopTime = LocalDateTime.parse(stop, dateTimeFormatter);
//        minute = stopTime.getMinute();
//        stopTime = stopTime.minusMinutes(minute);
//        System.out.println(Instant.ofEpochMilli(1585900800000L).atZone(ZoneOffset.ofHours(8)).toLocalDateTime());
//        System.out.println(Instant.ofEpochMilli(1585904400000L).atZone(ZoneOffset.ofHours(8)).toLocalDateTime());
//        System.out.println("开始时间：" + startTime);
//        System.out.println("结束时间：" + stopTime);
//        MatchOperation matchOperation =
//                Aggregation.match(Criteria.where("irri_mouth_id").is(irriMouthId)
//                        .and("event_time")
//                        .gte(startTime.atZone(ZoneOffset.ofHours(8)).toInstant().toEpochMilli())
//                        .lte(stopTime.atZone(ZoneOffset.ofHours(8)).toInstant().toEpochMilli())
//                );
//        GroupOperation groupOperation =
//                Aggregation.group("irri_mouth_id")
//                        .sum("hourly_accum_flow").as("总用水量");
//        Aggregation aggregation = Aggregation.newAggregation(matchOperation, groupOperation);
//        AggregationResults<BasicDBObject> aggregate = mongoTemplate.aggregate(aggregation, "mouth-hourly-count", BasicDBObject.class);
//        for (Iterator<BasicDBObject> iterable = aggregate.iterator(); iterable.hasNext(); ) {
//            System.out.println(iterable.next());
//        }


    }

    @Test
    public void testBatchInsert() {
        List<Student> students = Lists.newArrayList();
        Student student;
        for (int i = 0; i < 10; i++) {
            student = new Student();
            student.setStudentId(Integer.valueOf(2020 + "000" + i));
            student.setStudentName("张三" + i + "号");
            student.setAge(new Random().nextInt(30));
            student.setTestTime(new Date());
            students.add(student);
        }
        studentService.batchSave(students);
    }


    @Test
    public void groupBy() {
        GroupOperation groupOperation =
                Aggregation.group("age")
                        .count().as("人数");
        SortOperation sortOperation =
                Aggregation.sort(Sort.Direction.DESC, "人数");
        Aggregation aggregation = Aggregation.newAggregation(groupOperation, sortOperation);
        AggregationResults<BasicDBObject> aggregate = mongoTemplate.aggregate(aggregation, "my-test", BasicDBObject.class);
        for (Iterator<BasicDBObject> iterable = aggregate.iterator(); iterable.hasNext(); ) {
            System.out.println(iterable.next());
        }
    }

}
