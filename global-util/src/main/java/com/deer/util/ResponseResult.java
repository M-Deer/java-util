package com.deer.util;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @ClassName: ResponseResult.java
 * @Author: Mr_Deer
 * @Date: 2019年4月11日 下午12:20:09
 * @Description: 系统返回 json 结果封装类
 */
@Data
public class ResponseResult<T> implements Serializable {

    private static final long serialVersionUID = 7883830277373687855L;

    /**
     * 返回代码
     * 1：成功
     * -1：失败
     */
    private String status;

    /**
     * 携带的信息
     */
    private String message;

    /**
     * 结果对象
     */
    private T data;

    /**
     * 响应时间
     */
    private String time;

    /**
     * 返回成功的响应结果
     * 不携带消息
     *
     * @param data 携带对象
     * @return 封装结果
     */
    public static <F> ResponseResult successResult(F data) {
        ResponseResult<F> responseResult = new ResponseResult<>();
        responseResult.setStatus("1");
        responseResult.setMessage("操作成功");
        responseResult.setData(data);
        responseResult.setTime(GlobalDateUtil.dateTime2String(new Date()));

        return responseResult;
    }

    /**
     * 返回成功的响应结果
     * 不携带对象
     *
     * @param successMessage 成功提示信息
     * @return 封装结果
     */
    public static <F> ResponseResult successResult(String successMessage) {
        ResponseResult<F> responseResult = new ResponseResult<>();
        responseResult.setStatus("1");
        responseResult.setMessage(successMessage);
        responseResult.setData(null);
        responseResult.setTime(GlobalDateUtil.dateTime2String(new Date()));

        return responseResult;
    }

    /**
     * 返回成功的响应结果
     * 携带消息、对象
     *
     * @param successMessage 成功提示信息
     * @param data           携带对象
     * @return 封装结果
     */
    public static <F> ResponseResult successResult(String successMessage, F data) {
        ResponseResult<F> responseResult = new ResponseResult<>();
        responseResult.setStatus("1");
        responseResult.setMessage(successMessage);
        responseResult.setData(data);
        responseResult.setTime(GlobalDateUtil.dateTime2String(new Date()));

        return responseResult;
    }

    /**
     * 返回失败的响应结果
     * 不携带消息
     *
     * @param data 携带对象
     * @return 封装结果
     */
    public static <F> ResponseResult unsuccessResult(F data) {
        ResponseResult<F> responseResult = new ResponseResult<>();
        responseResult.setStatus("-1");
        responseResult.setMessage("操作失败");
        responseResult.setData(data);
        responseResult.setTime(GlobalDateUtil.dateTime2String(new Date()));

        return responseResult;
    }

    /**
     * 返回失败的响应结果
     * 不携带对象
     *
     * @param errorMessage 失败提示信息
     * @return 封装结果
     */
    public static <F> ResponseResult unsuccessResult(String errorMessage) {
        ResponseResult<F> responseResult = new ResponseResult<>();
        responseResult.setStatus("-1");
        responseResult.setMessage(errorMessage);
        responseResult.setData(null);
        responseResult.setTime(GlobalDateUtil.dateTime2String(new Date()));

        return responseResult;
    }

    /**
     * 返回失败的响应结果
     * 携带消息、对象
     *
     * @param errorMessage 失败提示信息
     * @param data         携带对象
     * @return 封装结果
     */
    public static <F> ResponseResult unsuccessResult(String errorMessage, F data) {
        ResponseResult<F> responseResult = new ResponseResult<>();
        responseResult.setStatus("-1");
        responseResult.setMessage(errorMessage);
        responseResult.setData(data);
        responseResult.setTime(GlobalDateUtil.dateTime2String(new Date()));

        return responseResult;
    }
}
