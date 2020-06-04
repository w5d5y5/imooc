package com.imooc.springboot.study.imoocspringbootstudy.async;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.endpoint.annotation.WriteOperation;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.HashMap;
import java.util.Map;

//自定义事件端点
//@Endpoint(id = "asyncExecutor")
public class AsyncEndpoint {
    ThreadPoolTaskExecutor   executor = new ThreadPoolTaskExecutor();
    @ReadOperation
    public Map<String,Object> info(){
        Map<String,Object> info =new HashMap<>();
        info.put("AsyncExecutor",executor.getCorePoolSize());
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();

        return  info;
    }
    //动态更改监控指标
    @WriteOperation
    public  void  setAsyncExecutor(ThreadPoolTaskExecutor executor){
        this.executor = executor;
    }

}
