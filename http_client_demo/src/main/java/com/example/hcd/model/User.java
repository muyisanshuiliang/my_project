package com.example.hcd.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

/**
 * @Author: yl Created by IntelliJ IDEA
 * DateTime: 2020/4/8 16:28
 * version:
 * description:
 */
@Data
@AllArgsConstructor
@RequiredArgsConstructor
@ToString
public class User {
    private Long id;
    private String username;
}
