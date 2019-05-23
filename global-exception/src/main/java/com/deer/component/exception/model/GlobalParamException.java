package com.deer.component.exception.model;

import lombok.EqualsAndHashCode;

import java.util.Map;

/**
 * @ClassName: GlobalParamException
 * @Author: Mr_Deer
 * @Date: 2019/5/15 17:03
 * @Describe: 自定义的全局异常——参数/数值/数据类型异常
 */
@EqualsAndHashCode(callSuper = true)
public class GlobalParamException extends GlobalException {

    private static final long serialVersionUID = 4273359201723302904L;

    public GlobalParamException(String exStatus, String message, Map<String, String> info) {
        super(exStatus, message, info);
    }
}
