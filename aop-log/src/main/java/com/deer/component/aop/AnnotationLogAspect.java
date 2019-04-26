package com.deer.component.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @ClassName: AnnotationLogAspect
 * @Author: Mr_Deer
 * @Date: 2019/4/26 11:00
 * @Description: 注解形式的拦截操作 AOP
 */
@Slf4j
@Aspect // 声明是个切面
@Component
public class AnnotationLogAspect {

    //切点入口 注解的完全限定名
    private final String pointcut = "@annotation(com.deer.component.annotation.OtherLog)";

    //切点
    @Pointcut(value = pointcut)
    public void otherLog() {
    }

    // 环切点
    @Around(value = "otherLog()")
    public Object around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        // 执行日志分析
        return new ExecuteLog().executeLog(proceedingJoinPoint);
    }
}
