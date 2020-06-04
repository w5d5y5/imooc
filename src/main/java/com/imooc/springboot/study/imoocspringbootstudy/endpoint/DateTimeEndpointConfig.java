package com.imooc.springboot.study.imoocspringbootstudy.endpoint;

import com.imooc.springboot.study.imoocspringbootstudy.async.AsyncEndpoint;
import com.imooc.springboot.study.imoocspringbootstudy.async.AsyncService;
import com.imooc.springboot.study.imoocspringbootstudy.config.AsyncPoolConfig;
import org.springframework.boot.actuate.autoconfigure.endpoint.condition.ConditionalOnEnabledEndpoint;
import org.springframework.boot.actuate.autoconfigure.health.ConditionalOnEnabledHealthIndicator;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.concurrent.Executor;

@Configuration
public class DateTimeEndpointConfig {
    @Bean
    @ConditionalOnMissingBean
    @ConditionalOnEnabledEndpoint
    public DateTimeEndpoint dateTimeEndpoint(){
        return  new  DateTimeEndpoint();
    }

    @Bean
    @ConditionalOnMissingBean
    @ConditionalOnEnabledEndpoint
    public AsyncPoolConfig ayncPoolConfig(){
        return  new  AsyncPoolConfig();
    }

}
