package com.example.spd.comport.exception;


/**
 * @Author yl
 * @Date 2019/12/31 15:51
 * @description:
 */
public class SerialPortInputStreamCloseFailure extends Exception {
    public SerialPortInputStreamCloseFailure() {
        throw new RuntimeException("关闭串口对象输入流出错");
    }
}
