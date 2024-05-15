package com.example.business.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @className: HelloController
 * @description: TODO 类描述
 * @date: 2024/5/14
 **/
@RestController
@RequestMapping("/api")
public class HelloController {

    @GetMapping("/hello")
    public String Hello() {
        return "Hello World";
    }
}
