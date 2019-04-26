package com.deer;

import com.deer.component.GlobalUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * 在开发中通用的、常用的一些工具类的整合
 */
@SpringBootApplication
public class GlobalUtilApplication {

    public static void main(String[] args) {
        // 获取上下文
        ConfigurableApplicationContext applicationContext = SpringApplication.run(GlobalUtilApplication.class, args);
        // 设置上下文
        GlobalUtil.setApplicationContext(applicationContext);
    }

}
