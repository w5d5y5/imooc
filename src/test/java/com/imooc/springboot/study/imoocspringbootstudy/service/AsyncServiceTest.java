package com.imooc.springboot.study.imoocspringbootstudy.service;

import com.imooc.springboot.study.imoocspringbootstudy.async.AsyncService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

@Slf4j
@SpringBootTest
@RunWith(SpringRunner.class)
public class AsyncServiceTest {

    @Autowired
    private AsyncService asyncService;

    @Test
    public  void  testAsyncProcess() throws  InterruptedException{
        asyncService.asyncProcess();
        log.info("coming  in  testAsyncProcess ........");
    }

    @Test
    public  void  testAsyncProcessHasReturn() throws InterruptedException, ExecutionException, TimeoutException {
        long start =System.currentTimeMillis();
        Future<Integer>  result =asyncService.asyncProcessHasReturn();

       // log.info("get  async task val:{}", result.get());
        log.info("get  async task val:{}", result.get(1, TimeUnit.SECONDS));
        log.info("time elapse for async task : {}ms",
                System.currentTimeMillis() -start);


    }

}
