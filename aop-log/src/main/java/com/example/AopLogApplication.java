package com.example;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class AopLogApplication {

    public static void main(String[] args) {
        log.info("AOP-Log Application Loading...");
        SpringApplication.run(AopLogApplication.class, args);
        log.info("AOP-Log Application Success...");
    }
}
