package com.xiahl.web.controller;

import com.xiahl.apicommon.entity.Res;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/hello")
@RestController
public class UserController {

    @GetMapping("/sayHello")
    public Res<String> getHello() {
        System.out.println("你好呀  ....springboot");
        return Res.success("hello world");
    }
}
