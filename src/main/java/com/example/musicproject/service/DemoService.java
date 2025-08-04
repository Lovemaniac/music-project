package com.example.musicproject.service;

import com.example.musicproject.annotation.LogOperation;
import org.springframework.stereotype.Service;

@Service
public class DemoService {

    @LogOperation("执行示例操作")
    public String doSomething(String name) {
        return "Hello, " + name;
    }
}
