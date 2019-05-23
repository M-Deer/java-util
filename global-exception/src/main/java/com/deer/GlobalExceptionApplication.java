package com.deer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @ClassName: GlobalExceptionApplication
 * @Author: Mr_Deer
 * @Date: 2019/5/15 16:29
 * @Description: 全局统一异常处理，处理的是 controller 的异常抛出
 */
@Slf4j
@SpringBootApplication
public class GlobalExceptionApplication {

    public static void main(String[] args) {
        log.info("Global-Exception Application Loading...");
        SpringApplication.run(GlobalExceptionApplication.class, args);
        log.info("Global-Exception Application Success...");
    }
}
