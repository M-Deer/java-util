package com.deer.util;

import org.springframework.context.ApplicationContext;

/**
 * @ClassName: GlobalSpringUtil
 * @Author: Mr_Deer
 * @Date: 2019/4/26 10:43
 * @Description: 在 Spring Boot 中获取上下文的工具类
 */
public class GlobalSpringUtil {

    // 全局上下文
    private static ApplicationContext applicationContext;

    /**
     * 设置当前上下文
     *
     * @param applicationContext 上下文
     */
    public static void setApplicationContext(ApplicationContext applicationContext) {
        if (GlobalUtil.isEmpty(applicationContext))
            applicationContext = applicationContext;
    }

    /**
     * 获取当前上下文
     *
     * @return ApplicationContext
     */
    public static ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    /**
     * 根据名称返回 Bean
     *
     * @param beanName 名称
     * @return Bean
     */
    public static Object getBean(String beanName) {
        return getApplicationContext().getBean(beanName);
    }

    /**
     * 根据 Class 返回 Bean
     *
     * @param clazz 类型
     * @return Bean
     */
    public static <T> T getBean(Class<T> clazz) {
        return getApplicationContext().getBean(clazz);
    }

    /**
     * 通过 Name,以及 Clazz 返回指定的 Bean
     *
     * @param beanName 名称
     * @param clazz    类型
     * @return Bean
     */
    public static <T> T getBean(String beanName, Class<T> clazz) {
        return getApplicationContext().getBean(beanName, clazz);
    }
}
