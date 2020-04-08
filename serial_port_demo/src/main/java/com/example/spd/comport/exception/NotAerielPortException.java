package com.example.spd.comport.exception;


/**
 * @Author yl
 * @Date 2019/12/31 15:44
 * @description:
 */
public class NotAerielPortException extends Exception {

    public NotAerielPortException() {
        throw new RuntimeException("端口指向设备不是串口类型");
    }
}
