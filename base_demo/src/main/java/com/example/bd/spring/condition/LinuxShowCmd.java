package com.example.bd.spring.condition;

/**
 * @Author yl
 * @Date 2019/12/18 15:34
 * @description:
 */
public class LinuxShowCmd implements ShowCmd {
    @Override
    public String showCmd() {
        return "ls";
    }
}
