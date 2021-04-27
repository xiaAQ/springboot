package com.xiahl.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.xiahl"})
public class BackCenterApplication {

    public static void main(String[] args) {
        SpringApplication.run(BackCenterApplication.class, args);
    }

}
