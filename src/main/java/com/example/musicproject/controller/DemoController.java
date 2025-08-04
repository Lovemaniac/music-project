package com.example.musicproject.controller;


import com.example.musicproject.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/demo")
public class DemoController {

    @Autowired
    private DemoService demoService;

    @GetMapping("/say")
    public String sayHello(@RequestParam String name) {
        return demoService.doSomething(name);
    }
}
