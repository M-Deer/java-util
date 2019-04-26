package com.deer.component.annotation;

import java.lang.annotation.*;

/**
 * @ClassName: OtherLog
 * @Author: Mr_Deer
 * @Description: 这里我们自定义一个注解
 * 该注解主要是在其他地方(除了 controller)其他地方想进行日志的 aop 处理
 * 可以使用该注解放在方法上
 */
@Target(ElementType.METHOD) // 表示该注解可使用的作用范围(类/方法)
/**
 * 定义注解被保留策略，一般有三种策略:
 * 1、RetentionPolicy.SOURCE 注解只保留在源文件中，在编译成class文件的时候被遗弃
 * 2、RetentionPolicy.CLASS 注解被保留在class中，但是在jvm加载的时候北欧抛弃，这个是默认的声明周期
 * 3、RetentionPolicy.RUNTIME 注解在jvm加载的时候仍被保留
 */
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface OtherLog {
    String value() default "";
}
