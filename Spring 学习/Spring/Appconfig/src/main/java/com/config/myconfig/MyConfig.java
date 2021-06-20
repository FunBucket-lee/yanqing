package com.config.myconfig;

import com.config.pojo.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

//这个也会被Spring容器托管，注册到容器中，本身就是一个@Component
@Configuration
@ComponentScan("com.config.pojo")
public class MyConfig {

    @Bean
    public User getUser(){
        return new User();
    }
}
