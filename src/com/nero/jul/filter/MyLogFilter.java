package com.nero.jul.filter;

import java.util.logging.Filter;
import java.util.logging.LogRecord;

//自定义的过滤器
public class MyLogFilter implements Filter {
    @Override
    public boolean isLoggable(LogRecord record) {
        //过滤掉日志为hello的记录
        return !record.getMessage().equals("hello");
    }
}
