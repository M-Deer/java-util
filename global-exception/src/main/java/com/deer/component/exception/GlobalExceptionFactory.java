package com.deer.component.exception;

import com.deer.component.enumm.ExEnum;
import com.deer.component.exception.model.*;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: GlobalExceptionFactory
 * @Author: Mr_Deer
 * @Date: 2019/5/15 16:54
 * @Describe: 创建自定义异常的工厂类，根据不同的需求创建不同的异常
 * @Doc: 该类是一个创建自定义异常的工厂类
 * Q：怎么创建异常？
 * A：在需要进行异常抛出的逻辑中断点处使用 “GlobalExceptionFactory.需要抛出的异常名” 即可。前面不用加 throw
 * 在代码中已经封装好了（在代码中已经有使用的地方了，可以全局搜索看一下）
 * <p>
 * Q：需要什么参数？
 * A：需要传递页面，显示给用户看的错误提示。这也是唯一一个需要的参数，其他的都不需要。
 * <p>
 * Q：为什么还要匹配自定义异常，JDK 中已经有了给定异常？
 * A：在程序运行中，我们可以在可预见的地方或者做逻辑中断点的地方进行手动的异常抛出，因为是可以预见的我们就尽量抛出自定的异常
 * jdk 自带的异常会在我们想不到的地方（Runtime）的时候自动抛出。同时，再抛出我们自己手动抛出异常的时候，就必须要给定显示给用户的错误信息
 * 使用 GlobalException 可以大胆的将信息传递到前端，而不会显示很多用户看不懂的信息。
 * <p>
 * Q：为什么自定义异常还要分类，多次一举？
 * A：这是将异常的颗粒度进行细化分类，在不同的逻辑中断点进行不同的异常抛出，给出 log 清晰明了，而且可以根据不同的状态
 * 给出不同的错误消息给用户。
 * <p>
 */
public class GlobalExceptionFactory {

    /**
     * 返回自定义的全局异常——空指针/空参数/空数值异常
     *
     * @param message 传递给前段的错误信息
     */
    public static void throwNllException(String message) throws GlobalNullException {
        Map<String, String> info = getInfo();
        throw new GlobalNullException(ExEnum.EXCEPTION_NULL.getCode(), message, info);
    }

    /**
     * 返回自定义的全局异常——空指针/空参数/空数值异常
     *
     * @param message 传递给前段的错误信息
     */
    public static void throwParamException(String message) throws GlobalParamException {
        Map<String, String> info = getInfo();
        throw new GlobalParamException(ExEnum.EXCEPTION_PARAM.getCode(), message, info);
    }

    /**
     * 返回自定义的全局异常——文件/文件夹路径不匹配
     *
     * @param message 传递给前段的错误信息
     */
    public static void throwFileNotFoundException(String message) throws GlobalFileNotFoundException {
        Map<String, String> info = getInfo();
        throw new GlobalFileNotFoundException(ExEnum.EXCEPTION_FILE_NOT_FOUND.getCode(), message, info);
    }

    /**
     * 返回自定义的全局异常——IO 流异常
     *
     * @param message 传递给前段的错误信息
     */
    public static void throwIOStreamException(String message) throws GlobalIOStreamException {
        Map<String, String> info = getInfo();
        throw new GlobalIOStreamException(ExEnum.EXCEPTION_IO_STREAM.getCode(), message, info);
    }

    /**
     * 返回自定义的全局异常——其他异常，当没有符合该异常时的次选项
     *
     * @param message 传递给前段的错误信息
     */
    public static void throwOtherException(String message) throws GlobalOtherException {
        Map<String, String> info = getInfo();
        throw new GlobalOtherException(ExEnum.EXCEPTION_OTHER.getCode(), message, info);
    }

    /**
     * 获取调用者的类信息
     *
     * @return Map：
     * key className - - 调用者的类名
     * key method    - - 调用者的方法名
     */
    private static Map<String, String> getInfo() {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        StackTraceElement element = stackTrace[3];
        Map<String, String> infoMap = new HashMap<>();
        infoMap.put("className", element.getClassName());
        infoMap.put("methodName", element.getMethodName());
        return infoMap;
    }
}
