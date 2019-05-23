package com.deer.component.exception.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.util.Map;

/**
 * @ClassName: GlobalException
 * @Author: Mr_Deer
 * @Date: 2019/5/15 17:00
 * @Describe: 自定义的全局异常，其中包括异常的编码和错误的提示
 * 该类为自定义异常的父类
 */
@EqualsAndHashCode(callSuper = true)
@Getter
public abstract class GlobalException extends Exception {

    private static final long serialVersionUID = 3656896168416242357L;

    // 异常状态码
    private String exStatus;
    // 需要传递到前段显示的信息
    private String message;
    // 触发异常的类
    private Map<String, String> info;

    GlobalException(String exStatus, String message, Map<String, String> info) {
        super(message);
        this.exStatus = exStatus;
        this.message = message;
        this.info = info;
    }
}
