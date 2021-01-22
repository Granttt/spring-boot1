package com.example.gxy.controller;

import com.example.gxy.service.RedissonCommonService;
import lombok.extern.slf4j.Slf4j;
import org.redisson.api.RLock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * @author GXY
 * @Package com.example.gxy.controller
 * @date 2020/11/13 15:52
 * @Copyright © 2020-2021 新流通
 * @Description:
 */
@Slf4j
@RestController
@RequestMapping("/redisson")
public class RedissonController {

    @Autowired
    private RedissonCommonService redissonCommonService;

    @GetMapping(value = "/test-rlock")
    public void testLock(String param) {
        RLock lock = redissonCommonService.getRLock(param);

        try {
            boolean bs = lock.tryLock(5, 6, TimeUnit.SECONDS);
            if (bs) {
                // 业务代码
                log.info("进入业务代码: " + param);

            } else {
                Thread.sleep(300);
            }
        } catch (Exception e) {
            log.error("", e);
            lock.unlock();
        }
        finally {
            lock.unlock();
        }
    }
}
