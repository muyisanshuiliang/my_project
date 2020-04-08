package com.example.spd.comport.exception;


/**
 * @Author yl
 * @Date 2019/12/31 15:51
 * @description:
 */
public class TooManyListeners extends Exception {
    public TooManyListeners() {
        throw new RuntimeException("监听类对象过多");
    }
}
