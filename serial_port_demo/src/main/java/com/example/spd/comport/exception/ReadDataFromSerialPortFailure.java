package com.example.spd.comport.exception;


/**
 * @Author yl
 * @Date 2019/12/31 15:51
 * @description:
 */
public class ReadDataFromSerialPortFailure extends Exception {
    public ReadDataFromSerialPortFailure() {
        throw new RuntimeException("从串口读取数据时出错");
    }
}
