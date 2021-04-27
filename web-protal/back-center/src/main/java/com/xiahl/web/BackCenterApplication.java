package com.xiahl.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.gson.GsonAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

/**
 * scanBasePackages可以扫描整个系统的com.xiahl包下的文件,并注册成bean,可以配置多个包,也可以使用@ComponentScan
 * exclude 可以排除一些配置,  例如druid的字段配置数据库
 */
@SpringBootApplication(scanBasePackages = {"com.xiahl"}, exclude = GsonAutoConfiguration.class)
public class BackCenterApplication {

    public static void main(String[] args) {
        SpringApplication.run(BackCenterApplication.class, args);
    }

}
