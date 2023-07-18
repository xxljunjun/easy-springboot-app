package com.example.xxlspringboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.mongo.MongoDataAutoConfiguration;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;

@SpringBootApplication(exclude = {MongoAutoConfiguration.class, MongoDataAutoConfiguration.class})
public class XxlSpringBootApplication {

    public static void main(String[] args) {

        SpringApplication.run(XxlSpringBootApplication.class, args);
        System.out.println("服务启动了！！！");
    }
}
