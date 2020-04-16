package com.nero.jul;

import java.util.logging.Level;
import java.util.logging.Logger;

//演示使用全局日志记录器
public class GlobalLoggerTest {
    public static void main(String[] args) {
        Logger.getGlobal().setLevel(Level.INFO);//配置全局日志记录器的等级
        Logger.getGlobal().info("info");
    }
}
