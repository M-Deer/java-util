package com.deer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 通过 AOP 切面完成系统操作日志的工具类
 */
@Slf4j
@SpringBootApplication
public class AopLogApplication {

    public static void main(String[] args) {
        log.info("AOP-Log Application Loading...");
        SpringApplication.run(AopLogApplication.class, args);
        log.info("AOP-Log Application Success...");
    }
}
