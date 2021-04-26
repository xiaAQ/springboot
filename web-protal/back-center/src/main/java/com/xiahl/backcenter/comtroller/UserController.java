package com.xiahl.backcenter.comtroller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/hello")
@RestController
public class UserController {

    @GetMapping("/sayHello")
    public String getHello() {
        System.out.println("你好呀  ....springboot");
        return "hello world";
    }
}
