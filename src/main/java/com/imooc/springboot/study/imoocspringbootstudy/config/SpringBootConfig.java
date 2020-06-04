package com.imooc.springboot.study.imoocspringbootstudy.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix= "imooc.springboot")
public class SpringBootConfig {


    private  String name;
    private  String version;
}
