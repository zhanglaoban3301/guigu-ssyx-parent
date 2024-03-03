package com.atguigu.ssyx;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.web.bind.annotation.CrossOrigin;


@SpringBootApplication
public class ServiceAclApplication {
    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(ServiceAclApplication.class);
    }
}
