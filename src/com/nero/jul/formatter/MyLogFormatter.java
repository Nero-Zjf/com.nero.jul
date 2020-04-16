package com.nero.jul.formatter;

import java.util.logging.Formatter;
import java.util.logging.LogRecord;

//自定义的格式化器
public class MyLogFormatter extends Formatter {
    @Override
    public String format(LogRecord record) {
        return "myLog-" + record.getLevel() + " " + record.getMessage() + "\n";
    }
}
