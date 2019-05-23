package com.deer.component.exception.model;

import lombok.EqualsAndHashCode;

import java.util.Map;

/**
 * @ClassName: GlobalFileNotFoundException
 * @Author: Mr_Deer
 * @Date: 2019/5/15 17:01
 * @Describe: 自定义的全局异常——文件/文件夹路径不匹配
 */
@EqualsAndHashCode(callSuper = true)
public class GlobalFileNotFoundException extends GlobalException {

    private static final long serialVersionUID = -7186699748486184708L;

    public GlobalFileNotFoundException(String exStatus, String message, Map<String, String> info) {
        super(exStatus, message, info);
    }
}