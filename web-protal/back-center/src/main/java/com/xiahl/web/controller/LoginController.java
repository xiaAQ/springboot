package com.xiahl.web.controller;


import ch.qos.logback.core.boolex.EvaluationException;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class LoginController {
    @GetMapping("/userlogin")
    @ApiOperationSupport(author = "xiahl")
    public String login(String userName, String password) {
        return "登陆账号和密码为"+userName + password;
    }
}
