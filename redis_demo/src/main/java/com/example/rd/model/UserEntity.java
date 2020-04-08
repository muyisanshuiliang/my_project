package com.example.rd.model;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author: yl Created by IntelliJ IDEA
 * DateTime: 2020/4/8 11:40
 * version:
 * description:
 */
@Data
public class UserEntity implements Serializable {
    private static final long serialVersionUID = -3391587182505038067L;
    private Long id;
    private String userName;
    private String userSex;
}
