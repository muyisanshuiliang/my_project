package com.example.bd.point;

import java.time.*;


/**
 * @Author: yl Created by IntelliJ IDEA
 * DateTime: 2020/4/2 11:17
 * version:
 * description:
 */
public class LocalDateTest {
    public static void main(String[] args) {

        ZonedDateTime date = ZonedDateTime.now();
        System.out.println(date);

        LocalTime standard = LocalTime.parse("10:30:30");
        date = (ZonedDateTime)standard.adjustInto(date);
        System.out.println(date);

    }
}
