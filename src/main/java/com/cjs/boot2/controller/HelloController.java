package com.cjs.boot2.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController


@RequestMapping("hello")
public class HelloController {

    @RequestMapping(value="/boot",method = RequestMethod.DELETE)
    public String hello() {
        return "Hello Spring Boot";//返回字符串

    }
}


