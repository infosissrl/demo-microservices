package com.example.demo.controller;

import org.springframework.web.bind.annotation.RestController;

@RestController("/demo")
public class DemoController {

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String sayHello() {
        return "Hello!";
    }
}
