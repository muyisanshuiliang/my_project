package com.example.spd.comport.exception;


/**
 * @Author yl
 * @Date 2019/12/31 15:50
 * @description:
 */
public class SerialPortOutputStreamCloseFailure extends Exception {
    public SerialPortOutputStreamCloseFailure() {
        throw new RuntimeException("关闭串口对象的输出流出错");
    }
}
