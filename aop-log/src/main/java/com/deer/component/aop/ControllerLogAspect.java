package com.deer.component.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @ClassName: ControllerLogAspect
 * @Author: Mr_Deer
 * @Description: 控制层的日志 AOP
 */
@Slf4j
@Aspect // 声明是个切面
@Component
public class ControllerLogAspect {

    //切点入口 controller包下面所有类的所有方法
    private final String pointcut = "execution(* com.deer.controller..*(..))";

    //切点
    @Pointcut(value = pointcut)
    public void controllerLog() {
    }

    // 环切点
    @Around(value = "controllerLog()")
    public Object around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        // 执行日志分析
        return new ExecuteLog().executeLog(proceedingJoinPoint);
    }
}
