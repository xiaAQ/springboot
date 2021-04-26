package com.xiahl.backcenter.comtroller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/hello")
@RestController
public class UserController {

    @GetMapping("/sayHello")
    public String getHello() {
        return "hello world";
    }
}
