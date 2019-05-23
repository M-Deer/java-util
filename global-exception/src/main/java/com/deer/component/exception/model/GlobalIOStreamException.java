package com.deer.component.exception.model;

import lombok.EqualsAndHashCode;

import java.util.Map;

/**
 * @ClassName: GlobalIOStreamException
 * @Author: Mr_Deer
 * @Date: 2019/5/15 17:02
 * @Describe: 自定义的全局异常——IO 流异常
 */
@EqualsAndHashCode(callSuper = true)
public class GlobalIOStreamException extends GlobalException {

    private static final long serialVersionUID = -2405591050456591759L;

    public GlobalIOStreamException(String exStatus, String message, Map<String, String> info) {
        super(exStatus, message, info);
    }
}
