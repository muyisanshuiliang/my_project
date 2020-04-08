package com.example.spd.comport.exception;


/**
 * @Author yl
 * @Date 2019/12/31 15:50
 * @description:
 */
public class PortInUseException extends Exception {
    public PortInUseException() {
        throw new RuntimeException("端口已被占用");
    }
}
