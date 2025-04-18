package com.core.springpractice.web;

import com.core.springpractice.common.MyLogger;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
class LogDemoService {
    private final MyLogger myLogger;

    public void login(String id) {
        myLogger.log("service Id = " + id);
    }
}
