package com.config.myconfig;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan("com.config.pojo")
@Import(MyConfig.class)
public class MyConfig2 {
}
