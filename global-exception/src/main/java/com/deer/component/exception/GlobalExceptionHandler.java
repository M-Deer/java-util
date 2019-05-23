package com.deer.component.exception;

import com.deer.component.enumm.ContentEnum;
import com.deer.component.enumm.ExEnum;
import com.deer.component.exception.model.GlobalException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * @ClassName: GlobalExceptionHandler
 * @Author: Mr_Deer
 * @Date: 2019/5/15 16:43
 * @Describe: 全局统一异常处理
 * @Doc： 在 exceptionHandler 中已经做了很多常见异常、自定义的异常等异常的匹配记录
 * Q：只能捕获 ajax 异常吗？
 * A：当然不是，下面的方法是 页面跳转/ajax 异常 双重捕获
 * <p>
 * Q：如果出现下列未定义的意料之外的异常怎么处理？
 * A：下面进行了很多的逻辑匹配，都没匹配上的情况下，会当作 OtherException 来看待
 * <p>
 * Q：怎么才能抛出/捕获/传递到前端？
 * A：代码中已经封装好了，我们不用关注以上问题。在出现异常的时候（ajax情况下），我们在ajax提供的 error 的回掉函数中处理
 * <p>
 * @ControllerAdvice(basePackages = "controller 的完全限定名")
 */
@Slf4j
@ControllerAdvice(basePackages = "com.deer.controller")
public class GlobalExceptionHandler {

    /**
     * 捕获未知的异常
     *
     * @param request  请求
     * @param response 响应
     * @param ex       异常
     * @return 返回异常的信息
     * <p>
     * @ExceptionHandler(value = xxxxx.class) 针对什么异常来进行捕获 Exception 是最大的
     */
    @ExceptionHandler(value = Exception.class)
    public Object exceptionHandler(HttpServletRequest request, HttpServletResponse response, Exception ex) {
        // 获取请求 url
        String requestUrl = request.getRequestURI();
        // 异常状态码，默认通用 500
        String exStatus;
        // 异常的类名，默认未知
        String className = "未知";
        // 异常的方法名，默认未知
        String methodName = "未知";
        // 异常的类型，如果是意料之外的，则显示默认
        String exType = "未知";
        // 异常简报
        String errorMessage = ex.getMessage();

        // 判断是否是 ajax 请求
        if (isAjax(request)) {
            // 判断是否为自定的全局异常
            if (ex instanceof GlobalException) {
                // 强转
                GlobalException globalException = (GlobalException) ex;
                // 获取异常状态码
                exStatus = globalException.getExStatus();
                // 获取类名
                className = globalException.getInfo().get("className");
                // 获取异常方法名
                methodName = globalException.getInfo().get("methodName");
                // 开始匹配异常的类型
                if (exStatus.equals(ExEnum.EXCEPTION_NULL.getCode())) {
                    exType = "空指针/空参数/空数值异常";
                } else if (exStatus.equals(ExEnum.EXCEPTION_PARAM.getCode())) {
                    exType = "参数/数值/数据类型异常";
                } else if (exStatus.equals(ExEnum.EXCEPTION_FILE_NOT_FOUND.getCode())) {
                    exType = "文件/文件夹路径不匹配";
                } else if (exStatus.equals(ExEnum.EXCEPTION_IO_STREAM.getCode())) {
                    exType = "IO 流异常";
                } else if (exStatus.equals(ExEnum.EXCEPTION_OTHER.getCode())) {
                    exType = "OtherException";
                }

                try {
                    // 在自定义通用异常的时候可以设置相应错误信息
                    response.sendError(Integer.parseInt(exStatus), errorMessage);
                } catch (IOException e) {
                    log.error(ContentEnum.SYSTEM_CONSOLE_EXCEPTION_INFO.getCode(), ex);
                }

            } else {
                if (ex instanceof NullPointerException)
                    exType = "空指针/空参数/空数值异常";
                else if (ex instanceof IllegalAccessException)
                    exType = "参数/数值/数据类型异常";
                else if (ex instanceof FileNotFoundException)
                    exType = "文件/文件夹路径不匹配";
                else if (ex instanceof IOException)
                    exType = "IO 流异常";
                else
                    exType = "OtherException";
                try {
                    // 在自定义通用异常的时候可以设置相应错误信息
                    response.sendError(500, null);
                } catch (IOException e) {
                    log.error(ContentEnum.SYSTEM_CONSOLE_EXCEPTION_INFO.getCode(), ex);
                }
            }
            log.error(ContentEnum.SYSTEM_GLOBAL_EXCEPTION_INFO.getCode(), "YES", requestUrl, className, methodName, exType, errorMessage, ex);
            return null;
        } else {
            log.error(ContentEnum.SYSTEM_GLOBAL_EXCEPTION_INFO.getCode(), "NO", requestUrl, className, methodName, exType, errorMessage, ex);
            // 跳转到错误页面
            return "error";
        }
    }

    /**
     * 判断是否为 ajax 请求
     *
     * @param httpServletRequest 请求
     * @return true：ajax请求    false：页面请求
     */
    private boolean isAjax(HttpServletRequest httpServletRequest) {
        return (httpServletRequest.getHeader("X-Requested-With") != null && "XMLHttpRequest".equals(httpServletRequest.getHeader("X-Requested-With")));
    }
}
