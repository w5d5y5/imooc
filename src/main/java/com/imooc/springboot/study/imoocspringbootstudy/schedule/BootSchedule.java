package com.imooc.springboot.study.imoocspringbootstudy.schedule;

//SpringBoot  定时任务

import lombok.extern.slf4j.Slf4j;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Slf4j
@Component
public class BootSchedule {
    private  final DateTimeFormatter fms = DateTimeFormatter.ofPattern("HH:mm:ss");
    /*
    上一次开始执行 3s 后再次执行
     */
    @Scheduled(fixedRate = 3000)
    public  void schedule01(){
        log.info("schedule01 ---> {}", LocalDateTime.now().format(fms));
    }
    /*
        上一次开始执行完毕 3s 后再次执行
         */
    @Scheduled(fixedDelay = 3000)
    public  void schedule02(){
        log.info("schedule02 ---> {}", LocalDateTime.now().format(fms));
    }
    /*
       第一次延迟2s 然后在以 3s一次 再次执行
        */
    @Scheduled(initialDelay = 2000,fixedRate = 3000)
    public  void schedule03(){
        log.info("schedule03 ---> {}", LocalDateTime.now().format(fms));
    }

    /*
       每3s 执行一次
        */
    @Scheduled(cron = "*/3 * * * * ?")
    public  void schedule04(){
        log.info("schedule04 ---> {}", LocalDateTime.now().format(fms));
    }

}
