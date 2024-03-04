package com.atguigu.ssyx;

import com.atguigu.ssyx.common.config.MyWebConfigurer;
import com.atguigu.ssyx.common.config.SecurityConfig;
import com.atguigu.ssyx.common.filter.CorsFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Import;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;


@SpringBootApplication
@Import({SecurityConfig.class,MyWebConfigurer.class})
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class ServiceAclApplication {
    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(ServiceAclApplication.class);
    }
}
