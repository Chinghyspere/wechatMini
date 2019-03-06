package com.ching.wechatstudy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
public class WechatStudyApplication {

    public static void main(String[] args) {
        SpringApplication.run(WechatStudyApplication.class, args);
    }

}

