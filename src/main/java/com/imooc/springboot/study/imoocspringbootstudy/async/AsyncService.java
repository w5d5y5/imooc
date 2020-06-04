package com.imooc.springboot.study.imoocspringbootstudy.async;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.endpoint.annotation.WriteOperation;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

//异步处理服务
@Slf4j
@Service
public class AsyncService {

    @Async("getAsyncExecutor")
    public  void asyncProcess() throws  InterruptedException {
        log.info("async  process task ,current thread  name  - > {}",
                Thread.currentThread().getName());
        TimeUnit.SECONDS.sleep(2);
    }

    @Async("getAsyncExecutor")
    public Future<Integer>  asyncProcessHasReturn() throws  InterruptedException{
        log.info("async  process task (has return),current thread  name  - > {}",
                Thread.currentThread().getName());
        TimeUnit.SECONDS.sleep(2);
        return  new AsyncResult<>(100);

    }



}
