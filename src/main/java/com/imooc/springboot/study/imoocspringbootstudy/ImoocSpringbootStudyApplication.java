package com.imooc.springboot.study.imoocspringbootstudy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

//开启异步支持
@EnableAsync
//开启定时任务
@EnableScheduling
@SpringBootApplication
public class ImoocSpringbootStudyApplication {

    public static void main(String[] args) {
        SpringApplication.run(ImoocSpringbootStudyApplication.class, args);
    }

}
