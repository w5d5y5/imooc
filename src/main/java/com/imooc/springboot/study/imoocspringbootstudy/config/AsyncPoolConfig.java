package com.imooc.springboot.study.imoocspringbootstudy.config;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.annotation.JsonAlias;
import com.imooc.springboot.study.imoocspringbootstudy.async.AsyncService;
import com.imooc.springboot.study.imoocspringbootstudy.endpoint.DateTimeEndpoint;
import lombok.extern.slf4j.Slf4j;
import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.boot.actuate.autoconfigure.endpoint.condition.ConditionalOnEnabledEndpoint;
import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.endpoint.annotation.WriteOperation;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

//自定义异步线程池的配置
@Slf4j
@Configuration
//自定义事件端点
@Endpoint(id = "asyncExecutor")
public class AsyncPoolConfig  implements AsyncConfigurer {
    ThreadPoolTaskExecutor   executor = new ThreadPoolTaskExecutor();
    @Bean
    @Override
    public Executor getAsyncExecutor(){
        //ThreadPoolTaskExecutor   executor = new ThreadPoolTaskExecutor();
        //核心线程数量
        executor.setCorePoolSize(10);
        //最大线程数量
        executor.setMaxPoolSize(20);
        //缓存队列任务队列
        executor.setQueueCapacity(20);
        //超出核心线程的 之后60S 杀死
        executor.setKeepAliveSeconds(60);
        //异步线程名称
        executor.setThreadNamePrefix("ImoocAsync_");
        //是否等待线程完毕关闭
        executor.setWaitForTasksToCompleteOnShutdown(true);
        //等待时长
        executor.setAwaitTerminationSeconds(60);

        //拒绝策略
        executor.setRejectedExecutionHandler(
                //等待并执行
                new ThreadPoolExecutor.AbortPolicy()
        );
        executor.initialize();

            return  executor;
    }
    //定义异步任务的异常处理类
    public AsyncUncaughtExceptionHandler  getAsyncUncaughtExceptionHandler(){
        return  new  AsyncExceptionHandler();
    }


    class AsyncExceptionHandler  implements AsyncUncaughtExceptionHandler{


        @Override
        public void handleUncaughtException(Throwable throwable,
                                            Method method, Object... objects) {
            log.info("AsyncErro :{} , Method :{}, Parm: {}",
                    throwable.getMessage(),
                    method.getName(),
                    JSON.toJSONString(objects));
            throwable.printStackTrace();
                //  TODD  发送邮件或者短信

        }
    }

    //private  String format ="yyyy-MM-dd HH:mm:ss";
    //显示监控指标
    ///imooc/actutor/asyncExecutor

    @ReadOperation
    public Map<String,Object> info(){
        Map<String,Object> info =new HashMap<>();
        info.put("AsyncExecutor",executor.getCorePoolSize());
        return  info;
    }
    //动态更改监控指标
    @WriteOperation
    public  void  setexsize(int exsize){
        this.executor.setCorePoolSize(exsize);
    }

}
