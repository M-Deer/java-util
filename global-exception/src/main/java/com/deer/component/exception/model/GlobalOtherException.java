package com.deer.component.exception.model;

import lombok.EqualsAndHashCode;

import java.util.Map;

/**
 * @ClassName: GlobalOtherException
 * @Author: Mr_Deer
 * @Date: 2019/5/15 17:03
 * @Describe: 自定义的全局异常——通用异常，当没有符合该异常时的次选项
 */
@EqualsAndHashCode(callSuper = true)
public class GlobalOtherException extends GlobalException {

    private static final long serialVersionUID = 3251403646074839842L;

    public GlobalOtherException(String exStatus, String message, Map<String, String> info) {
        super(exStatus, message, info);
    }
}