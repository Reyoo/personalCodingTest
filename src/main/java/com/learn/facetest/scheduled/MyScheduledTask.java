package com.learn.facetest.scheduled;


import ch.qos.logback.core.util.TimeUtil;
import com.alibaba.druid.util.StringUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.redisson.Redisson;
import org.redisson.api.RLock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.concurrent.TimeUnit;

@Configuration
@EnableScheduling
@Slf4j
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class MyScheduledTask {


    private final Redisson redisson;

//    @Scheduled(cron = "0/5 * * * * ?")
    @Scheduled(cron = "0 31 18 * * ? ")
    public void TeetRunRedissionTask()   {

        new Thread(() -> {
            RLock lock = redisson.getLock("strLock");
            Boolean locked = null;
            try {
                locked  = lock.tryLock(0,50, TimeUnit.SECONDS);
            } catch (InterruptedException e) {
                log.info("1 获取锁异常");
                e.printStackTrace();
            }
            if(!locked){
                return;
            }else {
                try {
                    lock.lock(2,TimeUnit.SECONDS);
                    log.info(Thread.currentThread() + " 1 执行逻辑代码");
                }finally {
                    lock.unlock();
                }

            }

        }).start();


//        new Thread(() -> {
//            RLock lock = redisson.getLock("strLock");
//            Boolean locked = null;
//            try {
//                locked  = lock.tryLock(0,50, TimeUnit.SECONDS);
//            } catch (InterruptedException e) {
//                log.info("2 获取锁异常");
//                e.printStackTrace();
//            }
//            if(!locked){
//                return;
//            }else {
//                try {
//                    lock.lock(2,TimeUnit.SECONDS);
//                    log.info(Thread.currentThread() + " 2 执行逻辑代码");
//                }finally {
//                    lock.unlock();
//                }
//
//            }
//
//        }).start();

    }

}
