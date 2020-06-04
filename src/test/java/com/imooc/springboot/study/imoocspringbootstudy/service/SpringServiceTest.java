package com.imooc.springboot.study.imoocspringbootstudy.service;

import com.alibaba.fastjson.JSON;

import com.imooc.springboot.study.imoocspringbootstudy.config.SpringBootConfig;
import lombok.extern.slf4j.Slf4j;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SuppressWarnings("ALL")
@Slf4j
@SpringBootTest
@RunWith(SpringRunner.class)
public class SpringServiceTest {

   // @Autowired
    ///private ISplitService splitService;
    @Autowired
    private SpringBootConfig springBootConfig;
    @Test
    public  void testSpitVersion(){
//        log.info("spit version : {}", JSON.toJSONString(
//               splitService.split(springBootConfig.getVersion())
//        ));
    }


}
