package com.deer.component.exception.model;

import lombok.EqualsAndHashCode;

import java.util.Map;

/**
 * @ClassName: GlobalNullException
 * @Author: Mr_Deer
 * @Date: 2019/5/15 17:03
 * @Describe: 自定义的全局异常——空指针/空参数/空数值异常
 */
@EqualsAndHashCode(callSuper = true)
public class GlobalNullException extends GlobalException {

    private static final long serialVersionUID = 8362251126010477108L;

    public GlobalNullException(String exStatus, String message, Map<String, String> info) {
        super(exStatus, message, info);
    }
}

