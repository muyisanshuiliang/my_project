package com.example.spd.comport.exception;


/**
 * @Author yl
 * @Date 2019/12/31 15:49
 * @description:
 */
public class NoSuchPortException extends Exception {

    public NoSuchPortException() {
        throw new RuntimeException("没有该端口对应的串口设备");
    }
}
