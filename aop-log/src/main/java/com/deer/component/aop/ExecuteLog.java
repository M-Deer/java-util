package com.deer.component.aop;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.Objects;

/**
 * @ClassName: ExecuteLog
 * @Author: Mr_Deer
 * @Date: 2019/4/26 11:04
 * @Description: 获取到拦截信息后，进行处理和解析
 */
@Slf4j
public class ExecuteLog {

    /**
     * 处理日志信息
     *
     * @param proceedingJoinPoint 切点信息
     * @return 结果
     */
    Object executeLog(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        log.info("环绕切点开始...");
        Object result;
        // 访问时间
        LocalDateTime now = LocalDateTime.now();
        StringBuilder sb = new StringBuilder("\n");
        try {
            // 获取 request
            HttpServletRequest request = ((ServletRequestAttributes) Objects
                    .requireNonNull(RequestContextHolder.getRequestAttributes()))
                    .getRequest();
            String requestURI = request.getRequestURI();
            sb.append(String.format("URL：\t%s\n", requestURI));

            // 获取类名 class
            sb.append(String.format("类名：\t%s\n", proceedingJoinPoint.getTarget().getClass().getName()));

            // 获取方法名 method
            MethodSignature methodSignature = (MethodSignature) proceedingJoinPoint.getSignature();
            sb.append(String.format("方法名：\t%s\n", methodSignature.getMethod().getName()));

            // 获取参数 param
            Object[] params = proceedingJoinPoint.getArgs();
            for (Object param : params) {
                sb.append(String.format("参数：\t%s\n", JSON.toJSON(param)));
            }

            // 计算消耗时间
            long startTime = System.currentTimeMillis();
            // 执行业务逻辑
            result = proceedingJoinPoint.proceed();
            long endTime = System.currentTimeMillis();
            sb.append(String.format("返回结果：\t%s\n", JSON.toJSON(result)));
            sb.append(String.format("执行时长：\t%ss\n", endTime - startTime));
            sb.append(String.format("访问时间：\t%s\n", now.toString()));
        } catch (Exception e) {
            // 捕获异常后的处理
            sb.append(String.format("返回结果：\t%s\n", ""));
            sb.append(String.format("执行时长：\t%ss\n", ""));
            sb.append(String.format("访问时间：\t%s\n", ""));
            log.error("异常捕获：", e);

            // 如果有统一异常处理，继续抛出，交给上层统一处理
            throw e;
        } finally {
            log.info(sb.toString());
        }
        return result;
    }
}
