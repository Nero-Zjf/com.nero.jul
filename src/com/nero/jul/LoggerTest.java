package com.nero.jul;

import com.nero.jul.filter.MyLogFilter;
import com.nero.jul.formatter.MyLogFormatter;

import java.io.IOException;
import java.util.logging.*;

//演示使用自定义的日志记录器
public class LoggerTest {
    //创建自定义的日志记录器
    private static final Logger logger = Logger.getLogger(LoggerTest.class.getName());

    public static void main(String[] args) throws IOException {
        //设置配置文件地址
        System.setProperty("java.util.logging.config.file", LoggerTest.class.getClassLoader().getResource("logging.properties").getPath());
        //重新读取 配置文件
        LogManager.getLogManager().readConfiguration();

        //不使用父Logger的处理器
        logger.setUseParentHandlers(false);

        //为Logger添加Console处理器
        ConsoleHandler consoleHandler = new ConsoleHandler();
        consoleHandler.setLevel(Level.INFO);
        //配置自定义格式化器
        consoleHandler.setFormatter(new MyLogFormatter());
        logger.addHandler(consoleHandler);

        //为Logger添加File处理器
        FileHandler fileHandler = new FileHandler();
        fileHandler.setFormatter(new MyLogFormatter());
        //配置自定义过滤器
        fileHandler.setFilter(new MyLogFilter());
        logger.addHandler(fileHandler);

        //设置等级为INFO
        logger.setLevel(Level.INFO);

        logger.info("info");
        logger.warning("warning");
        logger.log(Level.INFO, "hello");
        logger.config("config");
        logger.finer("finer");
    }
}
