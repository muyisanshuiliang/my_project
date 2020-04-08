package com.example.bd.point;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.irrigation.icl.utils.ObjectUtils;

import java.math.BigDecimal;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.*;

/**
 * @Author: yl Created by IntelliJ IDEA
 * DateTime: 2020/3/25 14:37
 * version:
 * description:
 */
public class TransDemo {
    public static void main(String[] args) {
//        Integer integer = objectTOInt(234.56);
//        System.out.println(integer);
//        integer = objectTOInt("234.77");
//        System.out.println(integer);
//        integer = objectTOInt("SSS");
//        System.out.println(integer);
//        integer = objectTOInt(987.65423);
//        System.out.println(integer);
//        System.out.println("测试完成");
        HashMap<Object, Object> objectObjectHashMap = Maps.newHashMap();
        Set<Map.Entry<Object, Object>> entries = objectObjectHashMap.entrySet();
        for (Map.Entry<Object, Object> item : objectObjectHashMap.entrySet()) {
            System.out.println(item.getKey() + "====>" + item.getValue());
        }

        ArrayList<Object> objects = Lists.newArrayList();
        System.out.println("是否包含:" + objects.contains(1));
        System.out.println("是否包含:" + objects.contains(null));
        objects.addAll(Lists.newArrayList());
        System.out.println(objects);

        long toEpochMilli = LocalDateTime.now().toInstant(ZoneOffset.of("+8")).toEpochMilli();
        LocalDateTime localDateTime1 = LocalDateTime.ofEpochSecond(toEpochMilli / 1000, 0, ZoneOffset.ofHours(8));
        System.out.println(localDateTime1);
        long toEpochMilli1 = LocalDateTime.now().minusDays(3).toInstant(ZoneOffset.of("+8")).toEpochMilli() - 200;
        LocalDateTime localDateTime2 = LocalDateTime.ofEpochSecond(toEpochMilli1 / 1000, 0, ZoneOffset.ofHours(8));
        System.out.println(localDateTime2);
        System.out.println(localDateTime1.isBefore(localDateTime2));
        System.out.println(localDateTime2.isBefore(localDateTime1));

        System.out.println("一年的第"+LocalDateTime.now().atZone(ZoneOffset.of("+8")).getDayOfYear()+"天");


        long toEpochMilli2 = LocalDateTime.now().atZone(ZoneOffset.of("+8")).toInstant().toEpochMilli();
        System.out.println(toEpochMilli2);
        LocalDateTime localDateTime = Instant.ofEpochMilli(toEpochMilli2).atOffset(ZoneOffset.ofHours(8)).toLocalDateTime();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String format = dateTimeFormatter.format(localDateTime);
        System.out.println(format);

    }


    private static Integer objectTOInt(Object o) {
//        if (ObjectUtils.isNull(o)) {
//            return 0;
//        }
//        if(o instanceof Integer){
//            return (Integer) o;
//        }
//        if(o instanceof Double){
//            return ((Double) o).intValue();
//        }
//        if (o instanceof Long){
//            return ((Long) o).intValue();
//        }
//        if (o instanceof Short){
//            return ((Short) o).intValue();
//        }
//        if (o instanceof Float){
//            return ((Float) o).intValue();
//        }
//        try {
//            return Integer.parseInt((String)o);
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        }
//        return null;
        if (ObjectUtils.isNull(o)) {
            return null;
        }
        BigDecimal bigDecimal = null;
        if (o instanceof Number && !(o instanceof Byte)) {
            bigDecimal = new BigDecimal(o.toString());
        } else if (o instanceof String) {
            try {
                bigDecimal = new BigDecimal(o.toString());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (ObjectUtils.isNull(bigDecimal)) {
            return null;
        }
        return bigDecimal.intValue();
    }
}
