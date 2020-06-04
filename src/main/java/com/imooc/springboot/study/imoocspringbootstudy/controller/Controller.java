package com.imooc.springboot.study.imoocspringbootstudy.controller;

import com.fasterxml.jackson.core.JsonProcessingException;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.imooc.springboot.study.imoocspringbootstudy.config.SpringBootConfig;
import com.imooc.springboot.study.imoocspringbootstudy.vo.Imoocer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.Date;

@Slf4j
@RestController
@RequestMapping("/springboot")
public class Controller {
    @Autowired
    private SpringBootConfig springBootConfig;

    @Autowired
    private ObjectMapper objectMapper;


    public  Controller(SpringBootConfig springBootConfig ){
        this.springBootConfig=springBootConfig;
    }

    @Value("${imooc.springboot.version}")
    private String version;
    @Value("${imooc.springboot.name}")
    private String name;
    @GetMapping("conf_inject_1")
    public  void  firstCont(){
        log.info("fist conf : {}, {}", version, name);
        System.out.println(version);
        System.out.println(name);
    }

    @GetMapping("conf_inject_2")
    public  void secondCon(){
        log.info("second conf : {}, {}", springBootConfig.getName(), springBootConfig.getVersion());
    }


    @GetMapping("/jackson")
    public Imoocer jackson() throws IOException {
        Imoocer imoocer =  Imoocer.builder()
                .name("zs")
                .address("bj")
                .age(20)
                .registerTime(new Date())
                .build();
        String jsonimoocer = objectMapper.writeValueAsString(imoocer);
        log.info("jason : {}",jsonimoocer);
        return  objectMapper.readValue(jsonimoocer,Imoocer.class);


    }
}
