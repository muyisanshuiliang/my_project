package com.example.spd.comport.exception;


/**
 * @Author yl
 * @Date 2019/12/31 15:50
 * @description:
 */
public class SendDataToSerialPortFailure extends Exception {
    public SendDataToSerialPortFailure() {
        throw new RuntimeException("向串口发送数据失败");
    }
}
