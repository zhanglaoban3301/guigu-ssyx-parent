package com.atguigu.ssyx;

import com.atguigu.ssyx.common.config.MyWebConfigurer;
import com.atguigu.ssyx.common.config.SecurityConfig;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;

@SpringBootApplication
@Import({SecurityConfig.class, MyWebConfigurer.class})
@EnableGlobalMethodSecurity(prePostEnabled = true)
@MapperScan({"com.atguigu.ssyx.product.dao"})
public class ServiceProApplication {
    public static void main(String[] args) {
        SpringApplication.run(ServiceProApplication.class);
    }
}
