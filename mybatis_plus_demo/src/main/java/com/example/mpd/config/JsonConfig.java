package com.example.mpd.config;

import com.fasterxml.jackson.databind.SerializationFeature;
import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: yl Created by IntelliJ IDEA
 * DateTime: 2020/4/8 17:27
 * version:
 * description:
 */
@Configuration
public class JsonConfig {

//    @Bean
//    public Jackson2ObjectMapperBuilderCustomizer customizer(){
//        return builder -> builder.featuresToEnable(SerializationFeature.WRITE_ENUMS_USING_TO_STRING);
//    }
}
