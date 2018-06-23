package com.example.demo.controller;

import org.springframework.web.bind.annotation.RestController;

@RestController("/demo")
public class DemoController {

    public String sayHello() {
        return "Hello!";
    }
}
