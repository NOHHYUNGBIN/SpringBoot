package com.core.springpractice.web;

import com.core.springpractice.common.MyLogger;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
class LogDemoService {
    private final ObjectProvider<MyLogger> myLoggerProvider;

    public void login(String id) {
        MyLogger myLogger = myLoggerProvider.getObject();
        myLogger.log("service Id = " + id);
    }
}
