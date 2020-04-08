package com.example.mpd.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;
import java.util.Optional;

/**
 * @Author: yl Created by IntelliJ IDEA
 * DateTime: 2020/4/8 16:54
 * version:
 * description:
 */
public enum SexEnum {

    BOY(1, "男生"),
    GIRL(2, "女生");

    /*标记存入数据库的值*/
    @EnumValue
    private final int code;

    /*标记响应JSON的值*/
    @JsonValue
    private final String description;

    SexEnum(int code, String description) {
        this.code = code;
        this.description = description;
    }

    public static SexEnum getSexEnum(int code) {
        SexEnum[] states = SexEnum.values();
        Optional<SexEnum> optional = Arrays
                .stream(states)
                .filter(t -> t.code == code).findFirst();
        return optional.isPresent() ? optional.get() : null;
    }

    /*必须覆写toString方法*/
    @Override
    public String toString(){
        return description;
    }

}
