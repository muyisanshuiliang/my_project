package com.example.bd.point;

import com.google.common.collect.Lists;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Collections;
import java.util.List;

/**
 * @Author: yl Created by IntelliJ IDEA
 * DateTime: 2020/3/26 16:29
 * version:
 * description:
 */
public class TestCompare {
    public static void main(String[] args) {
        List<Person> people = Lists.newArrayList();
        people.add(new Person(1L,"张三"));
        people.add(new Person(7L,"张三"));
        people.add(new Person(2L,"张三"));
        people.add(new Person(16L,"张三"));
        people.add(new Person(10L,"张三"));
        System.out.println(people);
        Collections.sort(people);
        System.out.println(people);
    }
}
@Data
@AllArgsConstructor
class Person implements Comparable<Person>{
    private Long age;
    private String name;

    @Override
    public int compareTo(Person o) {
        return (int)(o.age - this.age);
    }
}
