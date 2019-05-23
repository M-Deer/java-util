package com.deer.component.enumm;

/**
 * @ClassName: ExEnum
 * @Author: Mr_Deer
 * @Date: 2019/5/15 17:12
 * @Description:
 */
public enum ExEnum {
    EXCEPTION_OTHER("1000", "通用异常，当没有符合该异常时的次选项 ex_code"),
    EXCEPTION_NULL("1001", "空指针 ex_code"),
    EXCEPTION_PARAM("1002", "参数异常，数据类型不匹配 ex_code"),
    EXCEPTION_FILE_NOT_FOUND("1003", "找不到文件/文件夹 ex_code"),
    EXCEPTION_IO_STREAM("1004", "IO流 ex_code");

    private String code;
    private String mean;

    ExEnum(String code, String mean) {
        this.code = code;
        this.mean = mean;
    }

    public String getCode() {
        return this.code;
    }
}
