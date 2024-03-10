package com.atguigu.ssyx;

import com.atguigu.ssyx.common.config.MyWebConfigurer;
import com.atguigu.ssyx.common.config.SecurityConfig;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;

@SpringBootApplication
@Import({SecurityConfig.class,MyWebConfigurer.class})
@MapperScan({"com.atguigu.ssyx.mapper"})
@EnableDiscoveryClient
public class ServiceSysApplication {
    public static void main(String[] args) {
       SpringApplication.run(ServiceSysApplication.class);
    }
}
